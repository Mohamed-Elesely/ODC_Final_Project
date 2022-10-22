package com.example.fnal.network;

import com.example.fnal.model.Products;
import com.example.fnal.repository.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    private static RetroInstance instance = null;
    private APIService myApi;


    public  static String BASE_URL = "https://fakestoreapi.com/";//products

    private static Retrofit retrofit;

    public static Retrofit getRetroClient() {

        if(retrofit== null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }

    public static synchronized RetroInstance getInstance() {
        if (instance == null) {
            instance = new RetroInstance();
        }
        return instance;
    }

    public APIService getMyApi() {
        return myApi;
    }


}
