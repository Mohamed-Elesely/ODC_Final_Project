package com.example.fnal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionBarPolicy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fnal.R;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ImageView back = findViewById(R.id.back_product_details);
        TextView textView = findViewById(R.id.product_detail_name);
        TextView textView1 = findViewById(R.id.product_detail_price);
        TextView textView2 = findViewById(R.id.product_detail_desc);

        Intent intenty = getIntent();
        int id = intenty.getIntExtra("id",0);
        textView.setText(getIntent().getExtras().getString("title"));
        textView1.setText(getIntent().getExtras().getString("price"));
        textView2.setText(getIntent().getExtras().getString("desc"));
        String imageee = getIntent().getStringExtra("image");
        String last = setImage(imageee);

        String price = String.valueOf(getIntent().getExtras().getString("price"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ImageView imageView = findViewById(R.id.heart_product_details);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ProductDetail.this,Favorites.class);
                intent1.putExtra("titlee",getIntent().getExtras().getString("title"));
                intent1.putExtra("imagee", last);
                intent1.putExtra("pricee",price);
                startActivity(intent1);
            }
        });

        Button btn = findViewById(R.id.add_to_basket);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetail.this,MyCart.class);
                intent.putExtra("titleee",(getIntent().getExtras().getString("title")));
                intent.putExtra("imageee",last);
                intent.putExtra("priceee",price);
                startActivity(intent);
            }
        });


    }
//To deal with the URL of the image (The image is a string not an int)
    private String setImage (String imageURL ){
        ImageView imageView = findViewById(R.id.product_detail_image);
        Glide.with(this)
                .asBitmap()
                .load(imageURL)
                .into(imageView);
        return imageURL;
    }
}