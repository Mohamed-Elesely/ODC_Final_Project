package com.example.fnal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fnal.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    Context context;
    String[]items_texts;
    String[]items_prices;
    int[]items_images;
    public SearchAdapter(Context context , List listitem) {

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        TextView price;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.product_name_search);
            imageView=itemView.findViewById(R.id.product_image_search);
            price = itemView.findViewById(R.id.product_price_search);
        }
    }

    public SearchAdapter(Context context, String[] items_texts, int[] items_images, String[] items_prices){
        this.context=context;
        this.items_texts=items_texts;
        this.items_images=items_images;
        this.items_prices=items_prices;
    }
    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.search_item,parent,false);
        SearchAdapter.ViewHolder viewHolder = new SearchAdapter.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        holder.text.setText(items_texts[position]);
        holder.imageView.setImageResource(items_images[position]);
        holder.price.setText(items_prices[position]);
    }

    @Override
    public int getItemCount() {
        return items_texts.length;
    }

}