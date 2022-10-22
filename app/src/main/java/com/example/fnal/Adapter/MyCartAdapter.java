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
import com.example.fnal.model.CartList;

import java.util.List;

    public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder>{
    public List<CartList> data;

    public MyCartAdapter(List<CartList> data) {
        this.data=data;
    }

    @NonNull
    @Override
    public MyCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.cart_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartAdapter.ViewHolder holder, int position) {
        holder.name.setText(data.get(position).getTitle());
        holder.price.setText(data.get(position).getPrice() +"$");
        Glide.with(holder.image).load(data.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,price,quantity;
        public ImageView image;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name_cart);
            price = itemView.findViewById(R.id.product_price_cart);
            image = itemView.findViewById(R.id.product_image_cart);
            view = itemView;
        }
    }
}
