package com.example.fnal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fnal.Adapter.AccountAdapter;
import com.example.fnal.R;

public class Account extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    String[] account_items_texts ={"Orders","My Details", "Delivery Address", "Payment Methods",
    "Promo card", "Notifications", "Help", "About"};

    int[] account_items_images = {R.drawable.orders_icon,R.drawable.my_details_icon,R.drawable.delicery_address
            ,R.drawable.payment_icon,R.drawable.promo_cord_icon,
            R.drawable.notifecations_,R.drawable.help_icon,R.drawable.about_icon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ImageView imageView = findViewById(R.id.store_account_activity);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this,HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView imageViewe = findViewById(R.id.explore_account_activity);
        ImageView imageViewc = findViewById(R.id.mycart_account_activity);
        ImageView imageViewf = findViewById(R.id.fav_account_activity);
        ImageView imageViews = findViewById(R.id.store_account_activity);
        Button btn = findViewById(R.id.log_out_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this,SignIn.class);
                startActivity(intent);
            }
        });

        imageViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this,HomeScreen.class);
                startActivity(intent);
            }
        });
        imageViewe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this,Search.class);
                startActivity(intent);
            }
        });
        imageViewc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this,MyCart.class);
                startActivity(intent);
            }
        });imageViewf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this,Favorites.class);
                startActivity(intent);
            }
        });



        recyclerView=findViewById(R.id.recyler_account_activity);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Object account_adapter = new AccountAdapter(this, account_items_texts, account_items_images);
        recyclerView.setAdapter((RecyclerView.Adapter) account_adapter);

    }
}