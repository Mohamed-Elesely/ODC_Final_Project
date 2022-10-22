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

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

    Context context;
    String[]account_items_texts;
    int[]account_items_images;
    public AccountAdapter(Context context , List listitem) {

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text_account_item);
            imageView=itemView.findViewById(R.id.image_account_item);
        }
    }
    public AccountAdapter(Context context, String[] account_items_texts, int[]account_items_images){
        this.context=context;
        this.account_items_texts=account_items_texts;
        this.account_items_images=account_items_images;
    }
    @NonNull
    @Override
    public AccountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.account_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AccountAdapter.ViewHolder holder, int position) {
        holder.text.setText(account_items_texts[position]);
        holder.imageView.setImageResource(account_items_images[position]);
    }

    @Override
    public int getItemCount() {
        return account_items_texts.length;
    }


}
