package com.example.fnal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fnal.Adapter.FavoriteListAdapter;
import com.example.fnal.R;
import com.example.fnal.model.Favorite;

import java.util.ArrayList;
import java.util.List;

public class Favorites extends AppCompatActivity {
    String title;
    String image;
    String  price;

    static List<Favorite> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent=getIntent();
        title = intent.getStringExtra("titlee");
        image = intent.getStringExtra("imagee");
        price = intent.getStringExtra("pricee");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        ImageView imageViews = findViewById(R.id.store_fav_activity);
        ImageView imageViewsearch = findViewById(R.id.explore_fav_activity);
        ImageView imageViewc = findViewById(R.id.cart_fav_activity);
        ImageView imageViewa = findViewById(R.id.account_fav_activity);

        imageViewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorites.this,Account.class);
                startActivity(intent);
                finish();
            }
        });
        imageViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorites.this,HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
        imageViewsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorites.this,Search.class);
                startActivity(intent);
                finish();
            }
        });
        imageViewc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorites.this,MyCart.class);
                startActivity(intent);
                finish();
            }
        });

        data.add(new Favorite(title,image,price));
        RecyclerView recyclerView = findViewById(R.id.recyler_fav_activity);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Favorites.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        FavoriteListAdapter favoriteListAdapter = new FavoriteListAdapter(data);
        recyclerView.setAdapter(favoriteListAdapter);
        favoriteListAdapter.notifyDataSetChanged();
    }
}