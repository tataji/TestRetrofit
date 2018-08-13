package com.jetpackexample.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void retrofitcall(){
        ApiInterface apiInterface=RetrofitConnect.createService(ApiInterface.class);
        PointBookRequest pointBookRequest=new PointBookRequest();
        Request request=new Request();
        request.setModule(getIntent().getStringExtra("moduletype"));
        request.setPSID(getIntent().getStringExtra("psid"));
        request.setPage(""+pageNumber);
        request.setFromdate(getIntent().getStringExtra("fromdate"));
        request.setTodate(getIntent().getStringExtra("todate"));
        request.setRowsPage(""+RowspPage);
        pointBookRequest.setRequest(request);
        Call<PointBookReportsResponse> call;
        call = apiInterface.pointbookreportrequest(pointBookRequest);
        Log.d("pointbookrequest",pointBookRequest.getRequest().toString());
        call.enqueue(new Callback<PointBookReportsResponse>() {
            public void onResponse(Call<PointBookReportsResponse> call, Response<PointBookReportsResponse> response) {
                //list response
                List<DashboardList> dashboardList = response.body().getDashboardList();
                if(dashboardList.size()>0) {
                    Log.d("dashboardlist", String.valueOf(response.body().getDashboardList()));
                    pointBookRecyclerAdapter = new PointBookRecyclerAdapter(getApplicationContext(), (ArrayList<DashboardList>) dashboardList);
                    pointbook_recycler.setAdapter(pointBookRecyclerAdapter);
                }else {
                    Toast.makeText(getApplicationContext(),"No List Found",Toast.LENGTH_SHORT).show();
                }
            }
            public void onFailure(Call<PointBookReportsResponse> call, Throwable t) {

            }

        });
    }
}
