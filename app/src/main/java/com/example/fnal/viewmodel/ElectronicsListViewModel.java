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

public class ElectronicsListViewModel extends ViewModel {

    private MutableLiveData<List<Products>> electroins;

    public ElectronicsListViewModel(){
        electroins = new MutableLiveData<>();
    }
    public MutableLiveData<List<Products>> getProductsistObserver1(){
        return electroins;
    }

    public void makeAPICall1(){
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<Products>> call = apiService.getElectronics();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                electroins.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                electroins.postValue(null);
            }
        });
    }

}
