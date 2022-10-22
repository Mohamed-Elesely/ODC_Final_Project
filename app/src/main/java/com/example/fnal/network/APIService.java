package com.example.fnal.network;

import com.example.fnal.model.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface APIService {

    String BASE_URL = "https://fakestoreapi.com/";

    @GET("products")
    Call<List<Products>> getProducts();

    @GET("products/category/jewelery")
    Call<List<Products>> getJewelery();

    @GET("products/category/electronics")
    Call<List<Products>> getElectronics();

    @GET("products/category/men's clothing")
    Call<List<Products>> getMen();

    @GET("products/category/women's clothing")
    Call<List<Products>> getWomen();

}
