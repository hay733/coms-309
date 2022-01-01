package com.example.sumon.androidvolley;
import com.example.sumon.androidvolley.entities.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.*;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    /*
    @POST("register")
    Call<ResponseBody> createUser (
            @Body User user
    );
    */

    @GET("user/login")
    Call<User> checkLoginCredentials (
            @Query("email") String email,
            @Query("password") String password
    );

    @POST("user/create")
    Call<User> createUser (
            @Body User user
    );
}
