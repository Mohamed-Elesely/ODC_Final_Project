package com.example.fnal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.fnal.Adapter.CategoryListAdapter;
import com.example.fnal.Adapter.ClickListner;
import com.example.fnal.R;
import com.example.fnal.model.Category;

import java.util.ArrayList;
import java.util.List;

public class Explore extends AppCompatActivity {
    public List<Category> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        data.add(new Category("electronics","https://api.mobilaty.com/storage/uploads//aJzHCG-1647254060.png"));
        data.add(new Category("jewelery","https://www.pngkit.com/png/full/629-6299405_graff-emerald-earrings.png"));
        data.add(new Category("men's clothing","https://purepng.com/public/uploads/large/purepng.com-green-t-shirtclothingt-shirtt-shirtdressfashionclothshirt-691522330493iyjsl.png"));
        data.add(new Category("women's clothing","https://www.pngmart.com/files/22/new-year-dress-PNG-File.png"));

        RecyclerView recyclerView3 = findViewById(R.id.recycler_find_products);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Explore.this,2);
        recyclerView3.setLayoutManager(gridLayoutManager);
        ClickListner listener = new ClickListner() {
            @Override
            public void click(int index) {
                super.click(index);
                Intent intent = new Intent(Explore.this,Beverges.class);
                intent.putExtra("category_type",data.get(index).category);
                startActivity(intent);
            }
        };
        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(data,listener);
        recyclerView3.setAdapter(categoryListAdapter);
        categoryListAdapter.notifyDataSetChanged();
    }
}