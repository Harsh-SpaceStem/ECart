package com.spacestem.ecart.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacestem.ecart.R;

import org.jetbrains.annotations.NotNull;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    public ImageView productImage, img_favorite;
    public TextView productName, productMRP, productPrice;

    public ProductViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        productImage = itemView.findViewById(R.id.img_product);
        productName = itemView.findViewById(R.id.tv_productName);
        productMRP = itemView.findViewById(R.id.tv_customItemMRP);
        productPrice = itemView.findViewById(R.id.tv_customItemPrice);
        img_favorite = itemView.findViewById(R.id.img_favorite);
    }
}
