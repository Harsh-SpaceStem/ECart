package com.spacestem.ecart.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacestem.ecart.R;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    public ImageView profileItemImage, profileOpenImage;
    public TextView profileItemName, tv_custom_profileItemCount;

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        profileItemImage = itemView.findViewById(R.id.img_custom_profileItem);
        profileItemName = itemView.findViewById(R.id.tv_custom_profileName);
        profileOpenImage = itemView.findViewById(R.id.img_custom_profileOpen);
        tv_custom_profileItemCount = itemView.findViewById(R.id.tv_custom_profileItemCount);
    }
}
