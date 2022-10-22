package com.example.fnal.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fnal.R;
import com.example.fnal.model.Category;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder>{
    public List<Category> data;
    ClickListner listener;

    public CategoryListAdapter(List<Category> data , ClickListner listener) {
        this.data=data;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.find_products_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int index = holder.getAdapterPosition();
        holder.category.setText(data.get(position).category);
        Glide.with(holder.image).load(data.get(position).image).into(holder.image);
        holder.view.setOnClickListener(view ->
                listener.click(index));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView category;
        public ImageView image;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category_name);
            image = itemView.findViewById(R.id.category_image);
            view = itemView;
        }
    }
}
