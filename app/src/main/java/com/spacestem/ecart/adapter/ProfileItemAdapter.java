package com.spacestem.ecart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacestem.ecart.R;
import com.spacestem.ecart.ViewHolders.ProfileViewHolder;
import com.spacestem.ecart.listeners.ProfileItemClickListener;
import com.spacestem.ecart.model.ProfileItem;

import java.util.List;

public class ProfileItemAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

    Context context;
    List<ProfileItem> profileItemList;
    ProfileItemClickListener profileItemClickListener;

    public ProfileItemAdapter(Context context, List<ProfileItem> profileItemList, ProfileItemClickListener profileItemClickListener) {
        this.context = context;
        this.profileItemList = profileItemList;
        this.profileItemClickListener = profileItemClickListener;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_profile_list, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {

        holder.profileItemImage.setImageResource(profileItemList.get(position).getProfileItemImage());
        holder.profileItemName.setText(profileItemList.get(position).getProfileItemName());
        holder.profileOpenImage.setOnClickListener(v -> profileItemClickListener.onProfileItemSelected(profileItemList.get(position)));

        if (position == 4) {
            holder.tv_custom_profileItemCount.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return profileItemList.size();
    }
}
