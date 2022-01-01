package com.example.sumon.androidvolley;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static  final String BASE_URL = "http://coms-309-025.cs.iastate.edu:8080/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;


    private RetrofitClient () {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }


    public API getAPI () {
        return retrofit.create(API.class);
    }
}
