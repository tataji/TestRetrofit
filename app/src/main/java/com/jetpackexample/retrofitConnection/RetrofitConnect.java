package com.jetpackexample.retrofitConnection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnect {

    private static Retrofit retrofit;
    private static String BASE_URL="http://thaneservices.logicshore.co.in/Logicshore.svc/";
    public static void init() {
        if (retrofit == null) {
            Retrofit.Builder builder =
                    new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.build();
        }
    }

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
