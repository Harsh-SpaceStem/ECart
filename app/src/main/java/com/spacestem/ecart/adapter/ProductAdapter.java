package com.spacestem.ecart.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacestem.ecart.R;
import com.spacestem.ecart.ViewHolders.ProductViewHolder;
import com.spacestem.ecart.listeners.ProductClickListener;
import com.spacestem.ecart.model.Product;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    Context context;
    List<Product> productList;
    ProductClickListener productClickListener;

    public ProductAdapter(Context context, List<Product> productList, ProductClickListener productClickListener) {
        this.context = context;
        this.productList = productList;
        this.productClickListener = productClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductViewHolder holder, int position) {
        holder.productImage.setImageResource(productList.get(position).getProductImage());
        holder.productName.setText(productList.get(position).getProductName());
        holder.productPrice.setText(productList.get(position).getProductPrice());
        holder.productMRP.setText(productList.get(position).getProductMRP());
        holder.productMRP.setPaintFlags(holder.productMRP.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.itemView.setOnClickListener(v -> productClickListener.onProductClick(productList.get(position)));

        holder.img_favorite.setOnClickListener(v -> {
            productList.get(position).setAdded(!productList.get(position).isAdded());
            notifyDataSetChanged();
        });
        if (productList.get(position).isAdded()) {
            holder.img_favorite.setImageResource(R.drawable.ic_favorite_on);
        } else {
            holder.img_favorite.setImageResource(R.drawable.ic_favorite);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
