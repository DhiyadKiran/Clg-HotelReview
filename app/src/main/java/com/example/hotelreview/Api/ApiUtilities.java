package com.example.hotelreview.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    private static final String url="http://192.168.43.170/HotelReview/Api/";
    public static final String imageUrl="http://192.168.43.170/HotelReview/images/";
    private static ApiUtilities ApiUtilities;
    private static Retrofit retrofit;


    ApiUtilities(){
        retrofit  = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiUtilities getInstance(){
        if (ApiUtilities == null)
            ApiUtilities = new ApiUtilities();

        return ApiUtilities;
    }


    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }

}
