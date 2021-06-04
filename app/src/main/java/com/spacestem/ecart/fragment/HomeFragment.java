package com.spacestem.ecart.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.spacestem.ecart.R;
import com.spacestem.ecart.adapter.CategoryAdapter;
import com.spacestem.ecart.adapter.ProductAdapter;
import com.spacestem.ecart.adapter.SliderBannerAdapter;
import com.spacestem.ecart.listeners.CategoryClickListener;
import com.spacestem.ecart.listeners.ProductClickListener;
import com.spacestem.ecart.model.Category;
import com.spacestem.ecart.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment implements ProductClickListener, CategoryClickListener {

    RecyclerView rv_category, rv_recommendedProducts, rv_bestSellerProducts, rv_featuredProducts;
    CategoryAdapter adapter;
    ProductAdapter productAdapter;
    ViewPager pager;
    LinearLayout indicatorLayout;

    List<Category> categoryList = new ArrayList<>();
    List<Product> productList;

    List<Integer> sliderBannerList;
    TextView[] dots;
    Timer timer;

    NavController navController;
    NavDirections direction;

    @Override
    public void onDetach() {
        super.onDetach();
        timer.cancel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initSliderBanner(view);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void initSliderBanner(View view) {
        pager = view.findViewById(R.id.sliderPager);
        indicatorLayout = view.findViewById(R.id.layout_dot);
        initBannerList();

        SliderBannerAdapter adapter = new SliderBannerAdapter(getContext(), sliderBannerList);
        pager.setAdapter(adapter);
        addDot(0);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                requireActivity().runOnUiThread(() -> {
                    if (pager.getCurrentItem() != sliderBannerList.size() - 1) {
                        pager.setCurrentItem(pager.getCurrentItem() + 1);
                    } else {
                        pager.setCurrentItem(0);
                    }
                    addDot(pager.getCurrentItem());
                });
            }
        }, 2500, 2500);
    }

    public void addDot(int page_position) {
        dots = new TextView[sliderBannerList.size()];
        indicatorLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setPadding(0, 0, 5, 0);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(20);
            dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            indicatorLayout.addView(dots[i]);
        }
        //active dot
        dots[page_position].setTextColor(getResources().getColor(R.color.white));
    }

    private void initBannerList() {
        sliderBannerList = new ArrayList<>();
        sliderBannerList.add(R.drawable.banner1);
        sliderBannerList.add(R.drawable.banner2);
        sliderBannerList.add(R.drawable.banner3);
    }

    private void initView(View view) {
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        rv_category = view.findViewById(R.id.rv_category);
        rv_recommendedProducts = view.findViewById(R.id.rv_recommendedProducts);
        rv_bestSellerProducts = view.findViewById(R.id.rv_bestSellerProducts);
        rv_featuredProducts = view.findViewById(R.id.rv_featuredProducts);

        initCategoryList();
        initRecommendedList();
        initBestSellerList();
        initFeaturedProductList();
    }

    private void initBestSellerList() {
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.banner1, "Baby Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.t_shirt, "Child T Shirt", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.love_birds_dress, "Colorful Love Birds Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.colorful_body, "Elegant And Colorful Body", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.floral_body, "Floral Body with Flounces", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.green_jacket, "Green WaterProof Jacket", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.long_sleeved_dress, "Long Sleeved Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.pink_jacket, "Pink Jacket", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.red_shoes, "Red Shoes", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.pink_shoes, "Styles Shoes", "Rs. 14999", "Rs. 14999"));

        rv_bestSellerProducts.setNestedScrollingEnabled(false);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        productAdapter = new ProductAdapter(getContext(), productList, this);

        rv_bestSellerProducts.setLayoutManager(horizontalLayoutManager);
        rv_bestSellerProducts.setAdapter(productAdapter);
    }

    private void initFeaturedProductList() {
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.banner1, "Baby Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.t_shirt, "Child T Shirt", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.love_birds_dress, "Colorful Love Birds Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.colorful_body, "Elegant And Colorful Body", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.floral_body, "Floral Body with Flounces", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.green_jacket, "Green WaterProof Jacket", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.long_sleeved_dress, "Long Sleeved Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.pink_jacket, "Pink Jacket", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.red_shoes, "Red Shoes", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.pink_shoes, "Styles Shoes", "Rs. 14999", "Rs. 14999"));

        rv_featuredProducts.setNestedScrollingEnabled(false);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        productAdapter = new ProductAdapter(getContext(), productList, this);

        rv_featuredProducts.setLayoutManager(horizontalLayoutManager);
        rv_featuredProducts.setAdapter(productAdapter);
    }

    private void initRecommendedList() {
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.banner1, "Baby Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.t_shirt, "Child T Shirt", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.love_birds_dress, "Colorful Love Birds Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.colorful_body, "Elegant And Colorful Body", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.floral_body, "Floral Body with Flounces", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.green_jacket, "Green WaterProof Jacket", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.long_sleeved_dress, "Long Sleeved Dress", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.pink_jacket, "Pink Jacket", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.red_shoes, "Red Shoes", "Rs. 14999", "Rs. 14999"));
        productList.add(new Product(R.drawable.pink_shoes, "Styles Shoes", "Rs. 14999", "Rs. 14999"));

        rv_recommendedProducts.setNestedScrollingEnabled(false);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        productAdapter = new ProductAdapter(getContext(), productList, this);

        rv_recommendedProducts.setLayoutManager(horizontalLayoutManager);
        rv_recommendedProducts.setAdapter(productAdapter);
    }

    private void initCategoryList() {
        categoryList.add(new Category(R.drawable.appliances, "Appliances"));
        categoryList.add(new Category(R.drawable.electronics, "Electronics"));
        categoryList.add(new Category(R.drawable.fashion, "Fashion"));
        categoryList.add(new Category(R.drawable.grocery, "Grocery"));
        categoryList.add(new Category(R.drawable.home, "Home"));
        categoryList.add(new Category(R.drawable.mobile, "Mobile"));

        rv_category.setNestedScrollingEnabled(false);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new CategoryAdapter(getContext(), categoryList, this);

        rv_category.setLayoutManager(horizontalLayoutManager);
        rv_category.setAdapter(adapter);
    }

    @Override
    public void onProductClick(Product product) {
        direction = HomeFragmentDirections.actionHomeFragmentToProductDetailsFragment();
        navController.navigate(direction);

    }

    @Override
    public void onCategorySelected(Category category) {
        direction = HomeFragmentDirections.actionHomeFragmentToProductListFragment();
        navController.navigate(direction);
    }
}