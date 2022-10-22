package com.example.fnal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fnal.Adapter.ProductsAdapter;
import com.example.fnal.R;
import com.example.fnal.model.Products;
import com.example.fnal.viewmodel.ElectronicsListViewModel;
import com.example.fnal.viewmodel.JewelryViewModel;
import com.example.fnal.viewmodel.MensViewModel;
import com.example.fnal.viewmodel.WomenViewModel;

import java.util.List;

public class Beverges extends AppCompatActivity {

    private ElectronicsListViewModel viewModel;
    private MensViewModel viewModel1;
    private JewelryViewModel viewModel2;
    private WomenViewModel viewModel3;
    private ProductsAdapter adapter;
    private List<Products> productsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverges);
        TextView textView = findViewById(R.id.category_title);
        ImageView imageView = findViewById(R.id.back_beverge);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String title = getIntent().getStringExtra("category_type");
        textView.setText(title);
        switch (title) {
            case "electronics":
                RecyclerView recyclerView = findViewById(R.id.recycler_beverges);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(Beverges.this,2);
                recyclerView.setLayoutManager(gridLayoutManager);
                adapter = new ProductsAdapter(this, productsList);
                recyclerView.setAdapter(adapter);

                viewModel = new ViewModelProvider(this).get(ElectronicsListViewModel.class);
                viewModel.getProductsistObserver1().observe(this, new Observer<List<Products>>() {
                    @Override
                    public void onChanged(List<Products> products) {
                        if (products != null) {
                            productsList = products;
                            adapter.setProductsList(products);
                        }
                    }
                });
                viewModel.makeAPICall1();
                break;
            case "men's clothing":
                RecyclerView recyclerView2 = findViewById(R.id.recycler_beverges);
                GridLayoutManager gridLayoutManager2 = new GridLayoutManager(Beverges.this,2);
                recyclerView2.setLayoutManager(gridLayoutManager2);
                adapter = new ProductsAdapter(this, productsList);
                recyclerView2.setAdapter(adapter);

                viewModel1 = new ViewModelProvider(this).get(MensViewModel.class);
                viewModel1.getProductsistObserver2().observe(this, new Observer<List<Products>>() {
                    @Override
                    public void onChanged(List<Products> products) {
                        if (products != null) {
                            productsList = products;
                            adapter.setProductsList(products);
                        }
                    }
                });
                viewModel1.makeAPICall2();
                break;
            case "jewelery":
                RecyclerView recyclerView3 = findViewById(R.id.recycler_beverges);
                GridLayoutManager gridLayoutManager3 = new GridLayoutManager(Beverges.this,2);
                recyclerView3.setLayoutManager(gridLayoutManager3);
                adapter = new ProductsAdapter(this, productsList);
                recyclerView3.setAdapter(adapter);

                viewModel2 = new ViewModelProvider(this).get(JewelryViewModel.class);
                viewModel2.getProductsistObserver3().observe(this, new Observer<List<Products>>() {
                    @Override
                    public void onChanged(List<Products> products) {
                        if (products != null) {
                            productsList = products;
                            adapter.setProductsList(products);
                        }
                    }
                });
                viewModel2.makeAPICall3();
                break;
            case "women's clothing":
                RecyclerView recyclerView4 = findViewById(R.id.recycler_beverges);
                GridLayoutManager gridLayoutManager4 = new GridLayoutManager(Beverges.this,2);
                recyclerView4.setLayoutManager(gridLayoutManager4);
                adapter = new ProductsAdapter(this, productsList);
                recyclerView4.setAdapter(adapter);

                viewModel3 = new ViewModelProvider(this).get(WomenViewModel.class);
                viewModel3.getProductsistObserver4().observe(this, new Observer<List<Products>>() {
                    @Override
                    public void onChanged(List<Products> products) {
                        if (products != null) {
                            productsList = products;
                            adapter.setProductsList(products);
                        }
                    }
                });
                viewModel3.makeAPICall4();
                break;

        }
    }
}
