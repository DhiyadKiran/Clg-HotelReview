package com.example.hotelreview.Api;

import com.example.hotelreview.Model.AllDetail;
import com.example.hotelreview.Model.HomeHotel;
import com.example.hotelreview.Model.Responce;
import com.example.hotelreview.Model.UserDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("detail.php")
    Call<List<HomeHotel>> getData();

    //Fetch All Detail From DB
    @FormUrlEncoded
    @POST("alldetail.php")
    Call<AllDetail>  getDetail(
            @Field("id") int id);

    //    Get The User Details From Db
    @FormUrlEncoded
    @POST("user_read.php")
    Call<UserDetails> ReadUser(
            @Field("email") String email,
            @Field("password") String password
    );


    //    Send The User Details To Db
    @FormUrlEncoded
    @POST("user_add.php")
    Call<Responce> UserDetails(
            @Field("name") String name, @Field("email") String email,
            @Field("password") String password
    );


    //    Delete User
    @FormUrlEncoded
    @POST("user_delete.php")
    Call<Responce> DeleteUser(
            @Field("email") String email
    );
}
