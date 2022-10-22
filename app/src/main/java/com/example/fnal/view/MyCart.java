package com.example.fnal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fnal.Adapter.MyCartAdapter;
import com.example.fnal.R;
import com.example.fnal.model.CartList;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {
    ImageView shop,explore,cart,favorite,account;
    Button checkout;
    static List<CartList> data = new ArrayList<>();
    String title;
    String image;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent1 = getIntent();
        title=intent1.getStringExtra("titleee");
        image=intent1.getStringExtra("imageee");
        price=intent1.getStringExtra("priceee");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        ImageView imageViews = findViewById(R.id.store_mycart_activity);
        ImageView imageViewsearch = findViewById(R.id.explore_mycart_activity);
        ImageView imageViewf = findViewById(R.id.fav_mycart_activity);
        ImageView imageViewa = findViewById(R.id.account_mycart_activity);

        imageViewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCart.this,Account.class);
                startActivity(intent);
            }
        });
        imageViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCart.this,HomeScreen.class);
                startActivity(intent);
            }
        });
        imageViewsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCart.this,Search.class);
                startActivity(intent);
            }
        });imageViewf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCart.this,Favorites.class);
                startActivity(intent);
            }
        });

        Button btn = findViewById(R.id.GoToChechkout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCart.this,Checkout.class);
                startActivity(intent);
            }
        });

        data.add(new CartList(title,image,price));
        RecyclerView recyclerView = findViewById(R.id.recyler_My_cart_activity);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyCart.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyCartAdapter cartListAdapter = new MyCartAdapter(data);
        recyclerView.setAdapter(cartListAdapter);
        cartListAdapter.notifyDataSetChanged();

    }
}