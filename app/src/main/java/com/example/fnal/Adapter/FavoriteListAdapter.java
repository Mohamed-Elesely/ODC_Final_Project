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
import com.example.fnal.model.Favorite;

import java.util.List;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.ViewHolder>{

    public List<Favorite> data;

    public FavoriteListAdapter(List<Favorite> data) {
        this.data=data;
    }

    @NonNull
    @Override
    public FavoriteListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.favorite_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteListAdapter.ViewHolder holder, int position) {
        holder.name.setText(data.get(position).getTitle());
        holder.price.setText(data.get(position).getPrice() +"$");
        Glide.with(holder.photo).load(data.get(position).getImage()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,price;
        public ImageView photo;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_detail_price);
            photo = itemView.findViewById(R.id.product_image);
            view = itemView;
        }
    }
}