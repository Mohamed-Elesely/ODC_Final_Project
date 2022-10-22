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
import com.example.fnal.model.Products;
import java.util.List;

public class CategoryItemListAdapter extends RecyclerView.Adapter<CategoryItemListAdapter.ViewHolder>{
    public List<Products> data;
    ClickListner listener;

    public CategoryItemListAdapter(List<Products> data , ClickListner listener) {
        this.data=data;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.product_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int index = holder.getAdapterPosition();
        holder.name.setText(data.get(position).title);
        holder.quantity.setText("Stock: "+String.valueOf(data.get(position).rating.count)+" Pieces");
        holder.price.setText(String.valueOf(data.get(position).price)+"$");
        Glide.with(holder.photo).load(data.get(position).image).into(holder.photo);
        holder.view.setOnClickListener(view ->
                listener.click(index));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,quantity,price;
        public ImageView photo;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name_home);
            quantity = itemView.findViewById(R.id.product_quantity_home);
            price = itemView.findViewById(R.id.product_price_home);
            photo = itemView.findViewById(R.id.product_image_home);
            view = itemView;
        }
    }
}
