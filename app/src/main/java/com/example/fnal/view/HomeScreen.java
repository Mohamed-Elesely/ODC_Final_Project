package com.example.fnal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fnal.Adapter.ClickListner;
import com.example.fnal.Adapter.ProductsAdapter;
import com.example.fnal.Adapter.RectangularListAdapter;
import com.example.fnal.R;
import com.example.fnal.model.Category;
import com.example.fnal.model.Products;
import com.example.fnal.viewmodel.ProductsListViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {


    private List<Products> productsList;
    private ProductsAdapter adapter;
    private ProductsListViewModel viewModel;
    List<Category> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ImageView imageViewe = findViewById(R.id.explore_home_screen);
        ImageView imageViewc = findViewById(R.id.cart_home_screen);
        ImageView imageViewf = findViewById(R.id.favorite_home_screen);
        ImageView imageViewa = findViewById(R.id.account_home_screen);
        RecyclerView recyclerCatg = findViewById(R.id.catgegory_recycler);
        TextView movetocateg = findViewById(R.id.see_all_textview);

        imageViewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, Account.class);
                startActivity(intent);
            }
        });
        imageViewe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, Search.class);
                startActivity(intent);
            }
        });
        imageViewc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, MyCart.class);
                startActivity(intent);
            }
        });
        imageViewf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, Favorites.class);
                startActivity(intent);
            }
        });
        movetocateg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this,Explore.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.firstRecyclerView);
        LinearLayoutManager layoutmanger = new LinearLayoutManager(HomeScreen.this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutmanger);
        adapter = new ProductsAdapter(this, productsList);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(ProductsListViewModel.class);
        viewModel.getProductsistObserver().observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                if (products != null) {
                    productsList = products;
                    adapter.setProductsList(products);
                }
            }
        });

        viewModel.makeAPICall();

        data.add(new Category("electronics","https://api.mobilaty.com/storage/uploads//aJzHCG-1647254060.png"));
        data.add(new Category("jewelery","https://www.pngkit.com/png/full/629-6299405_graff-emerald-earrings.png"));
        data.add(new Category("men's clothing","https://purepng.com/public/uploads/large/purepng.com-green-t-shirtclothingt-shirtt-shirtdressfashionclothshirt-691522330493iyjsl.png"));
        data.add(new Category("women's clothing","https://www.pngmart.com/files/22/new-year-dress-PNG-File.png"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeScreen.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerCatg.setLayoutManager(linearLayoutManager);
        ClickListner listener = new ClickListner() {
            @Override
            public void click(int index) {
                super.click(index);
                Intent intent = new Intent(HomeScreen.this, Beverges.class);
                intent.putExtra("category_type",data.get(index).category);
                startActivity(intent);
            }
        };
        RectangularListAdapter rectangularListAdapter = new RectangularListAdapter(data,listener);
        recyclerCatg.setAdapter(rectangularListAdapter);
        rectangularListAdapter.notifyDataSetChanged();

    }
}