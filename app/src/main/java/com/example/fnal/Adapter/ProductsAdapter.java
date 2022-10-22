package com.example.fnal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fnal.R;
import com.example.fnal.model.Products;
import com.example.fnal.view.ProductDetail;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private Context context;
    private List<Products> productsList;

    public ProductsAdapter(Context context,List<Products> productsList){
        this.context=context;
        this.productsList=productsList;
    }

    public void setProductsList(List<Products> productsList){
        this.productsList=productsList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ProductsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.MyViewHolder holder, int position) {
        final Products data_positon = productsList.get(position);
        holder.textView.setText(this.productsList.get(position).getTitle().toString());
        holder.textView2.setText(String.valueOf(this.productsList.get(position).getPrice()));
        holder.textView3.setText(String.valueOf(this.productsList.get(position).getRating().count));
        Glide.with(context)
                .load(this.productsList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetail.class);
                intent.putExtra("title",data_positon.getTitle());
                intent.putExtra("id",data_positon.getId());
                intent.putExtra("image",data_positon.getImage());
                intent.putExtra("price",String.valueOf(data_positon.getPrice()));
                intent.putExtra("desc",data_positon.getDescription());
                v.getContext().startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        if(this.productsList !=null){
            return this.productsList.size();
        }
        return 0;
    }



    public  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        TextView textView2;
        TextView textView3;
        CardView layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.product_image_home);
            textView = itemView.findViewById(R.id.product_name_home);
            textView2 = itemView.findViewById(R.id.product_price_home);
            textView3 = itemView.findViewById(R.id.product_quantity_home);
            layout = itemView.findViewById(R.id.cardview_layout);
        }

    }
}
