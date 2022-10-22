package com.example.fnal.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fnal.model.Products;
import com.example.fnal.network.APIService;
import com.example.fnal.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsListViewModel extends ViewModel {

    private MutableLiveData<List<Products>> productsist;

    public ProductsListViewModel(){
        productsist = new MutableLiveData<>();
    }
    public MutableLiveData<List<Products>> getProductsistObserver(){
        return productsist;
    }

    public void makeAPICall(){
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<Products>> call = apiService.getProducts();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                productsist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                productsist.postValue(null);
            }
        });
    }

}
