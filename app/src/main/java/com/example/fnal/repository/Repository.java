package com.example.fnal.repository;

import com.example.fnal.model.Products;
import com.example.fnal.network.RetroInstance;
import java.util.List;

import retrofit2.Call;

public class Repository {
    public Call<List<Products>> getProducts() {
        return RetroInstance.getInstance().getMyApi().getProducts();
    }

    public Call<List<Products>> getJewelery() {
        return RetroInstance.getInstance().getMyApi().getJewelery();
    }

    public Call<List<Products>> getElectronics() {
        return RetroInstance.getInstance().getMyApi().getElectronics();
    }

    public Call<List<Products>> getMen() {
        return RetroInstance.getInstance().getMyApi().getMen();
    }

    public Call<List<Products>> getWomen() {
        return RetroInstance.getInstance().getMyApi().getWomen();
    }
}
