package com.spacestem.ecart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.spacestem.ecart.R;

import java.util.List;

public class SliderBannerAdapter extends PagerAdapter {

    Context context;
    List<Integer> bannerList;

    public SliderBannerAdapter(Context context, List<Integer> bannerList) {
        this.context = context;
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_banner, container, false);
        ImageView imageView = view.findViewById(R.id.img_banner);
        //int banner = bannerList.get(position);
        imageView.setImageResource(bannerList.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return bannerList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
