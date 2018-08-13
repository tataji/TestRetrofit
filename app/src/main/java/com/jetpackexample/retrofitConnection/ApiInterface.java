package com.jetpackexample.retrofitConnection;


import com.logicshore.smartcops.WorkBasket.pointbookreports.PointBookReportsResponse;
import com.logicshore.smartcops.WorkBasket.pointbookreports.PointBookRequest;
import com.logicshore.smartcops.WorkBasket.pointbookreports.PointBookVisitedResponse;
import com.logicshore.smartcops.usageReport.UsageReport;
import com.logicshore.smartcops.usageReport.UsageReportResponse;

import retrofit2.Call;
import retrofit2.http.*;


public interface ApiInterface {
    @POST("SCPointBookDashBoardDetails")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<PointBookReportsResponse> pointbookreportrequest(@Body PointBookRequest post);
}
