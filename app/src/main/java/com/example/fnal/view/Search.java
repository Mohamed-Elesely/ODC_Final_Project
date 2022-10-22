package com.example.fnal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fnal.Adapter.SearchAdapter;
import com.example.fnal.R;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String[]search_texts={"Egg Chicken Red","Egg Chicken White","Egg Pasta ","Egg Noodles","Mayonnais Eggless","Egg Noodles"};
        int[] images = {R.drawable.egg1,R.drawable.egg2,R.drawable.egg3,R.drawable.egg5,R.drawable.egg4,R.drawable.egg6};
        String [] prices ={"$1.99","$1.50","$15.99","$15.99","$12.45","$10.55"};

        ImageView imageViews = findViewById(R.id.shop_search_screen);
        ImageView imageViewc = findViewById(R.id.cart_search_screen);
        ImageView imageViewf = findViewById(R.id.fav_search_screen);
        ImageView imageViewa = findViewById(R.id.account_search_screen);
        ImageView imageViewfilter= findViewById(R.id.Filter_cart);

        imageViewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,Account.class);
                startActivity(intent);
            }
        });
        imageViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,HomeScreen.class);
                startActivity(intent);
            }
        });
        imageViewc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,MyCart.class);
                startActivity(intent);
            }
        });
        imageViewf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,Favorites.class);
                startActivity(intent);
            }
        });
        imageViewfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this, Filters.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_search);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        Object SearchAdapter = new SearchAdapter(this, search_texts, images, prices);
        recyclerView.setAdapter((RecyclerView.Adapter) SearchAdapter);

    }
}