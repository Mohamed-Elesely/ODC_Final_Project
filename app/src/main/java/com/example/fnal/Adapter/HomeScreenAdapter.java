package com.example.fnal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fnal.R;
import com.example.fnal.model.CartList;

import java.util.List;

public class HomeScreenAdapter extends RecyclerView.Adapter<HomeScreenAdapter.ViewHolder> {
    private Context context;
    private List<com.example.fnal.model.CartList> CartList;

    public HomeScreenAdapter(Context context, List<CartList> CartList) {
        this.context = context;
        this.CartList = CartList;
    }

    public void setCartList(List<CartList> cartList) {
        this.CartList = cartList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(this.CartList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
        holder.textView.setText(CartList.get(position).getTitle());
        holder.textView2.setText(String.valueOf(CartList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        if(this.CartList !=null){
            return this.CartList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        TextView textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.product_name_cart);
            imageView = itemView.findViewById(R.id.product_image_cart);
            textView2= itemView.findViewById(R.id.product_price_cart);
        }
    }
}


