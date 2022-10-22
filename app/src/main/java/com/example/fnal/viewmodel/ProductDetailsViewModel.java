package com.example.fnal.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fnal.model.Products;
import com.example.fnal.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsViewModel extends ViewModel {
    public MutableLiveData<List<Products>> listMutableLiveData = new MutableLiveData<>();
    RetroInstance repo = new RetroInstance();
    public void getData(){
        Call<List<Products>> call = repo.getMyApi().getProducts();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }
}
