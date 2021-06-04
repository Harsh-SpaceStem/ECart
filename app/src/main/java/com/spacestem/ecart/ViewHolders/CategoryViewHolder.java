package com.spacestem.ecart.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacestem.ecart.R;

import org.jetbrains.annotations.NotNull;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public ImageView categoryImage;
    public TextView categoryName;

    public CategoryViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        categoryImage = itemView.findViewById(R.id.img_categoryIcon);
        categoryName = itemView.findViewById(R.id.tv_categoryName);
    }
}
