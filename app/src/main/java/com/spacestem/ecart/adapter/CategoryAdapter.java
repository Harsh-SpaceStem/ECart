package com.spacestem.ecart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacestem.ecart.R;
import com.spacestem.ecart.ViewHolders.CategoryViewHolder;
import com.spacestem.ecart.listeners.CategoryClickListener;
import com.spacestem.ecart.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    Context context;
    List<Category> categoryList;
    CategoryClickListener categoryClickListener;

    public CategoryAdapter(Context context, List<Category> categoryList, CategoryClickListener categoryClickListener) {
        this.context = context;
        this.categoryList = categoryList;
        this.categoryClickListener = categoryClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_horizontal_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.categoryName.setText(categoryList.get(position).getCategoryName());
        holder.categoryImage.setImageResource(categoryList.get(position).getCategoryIcon());

        holder.itemView.setOnClickListener(v -> categoryClickListener.onCategorySelected(categoryList.get(position)));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
