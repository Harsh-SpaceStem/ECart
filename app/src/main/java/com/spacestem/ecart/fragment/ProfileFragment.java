package com.spacestem.ecart.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.spacestem.ecart.R;
import com.spacestem.ecart.adapter.ProfileItemAdapter;
import com.spacestem.ecart.listeners.ProfileItemClickListener;
import com.spacestem.ecart.model.ProfileItem;
import com.spacestem.ecart.utils.PreferenceManager;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment implements ProfileItemClickListener {

    TextView tv_name, tv_email;
    ImageView img_editProfile, img_userProfile;

    PreferenceManager preferenceManager;
    RecyclerView recyclerView;
    NavDirections direction;
    NavController navController;
    ProfileItemAdapter profileItemAdapter;
    List<ProfileItem> profileItemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initView(view);

        return view;
    }


    private void initView(View view) {
        preferenceManager = new PreferenceManager(getContext());

        tv_email = view.findViewById(R.id.tv_profileEmail);
        tv_name = view.findViewById(R.id.tv_profileName);
        img_editProfile = view.findViewById(R.id.img_editProfile);
        img_userProfile = view.findViewById(R.id.img_userProfile);

        recyclerView = view.findViewById(R.id.rv_profileItems);

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        getProfileDetails();

        setUpProfileItemList();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img_editProfile.setOnClickListener(v -> {
            direction = ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment();
            navController.navigate(direction);
        });
    }

    private void setUpProfileItemList() {
        profileItemList = new ArrayList<>();
        profileItemList.add(new ProfileItem(R.drawable.ic_profile_home, "My Orders"));
        profileItemList.add(new ProfileItem(R.drawable.ic_wishlist, "My WishList"));
        profileItemList.add(new ProfileItem(R.drawable.ic_card, "My Cards"));
        profileItemList.add(new ProfileItem(R.drawable.ic_address, "My Address"));
        profileItemList.add(new ProfileItem(R.drawable.ic_helpcenter, "Help Center"));

        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        profileItemAdapter = new ProfileItemAdapter(getContext(), profileItemList, this);
        recyclerView.setAdapter(profileItemAdapter);
    }


    private void getProfileDetails() {
        List<String> userDetails = preferenceManager.getUserDetails();
        String email = userDetails.get(0);
        String name = userDetails.get(1);

        if (email != null) {
            tv_email.setText(email);
        } else {
            tv_email.setText(getString(R.string.email));
        }

        if (name != null) {
            tv_name.setText(name);
        } else {
            tv_name.setText(getString(R.string.full_name));
        }
    }

    @Override
    public void onProfileItemSelected(ProfileItem profileItem) {
        String profileItemName = profileItem.getProfileItemName();
        switch (profileItemName) {
            case "My Orders":
                direction = ProfileFragmentDirections.actionProfileFragmentToMyOrdersFragment();
                navController.navigate(direction);
                break;
            case "My WishList":
                direction = ProfileFragmentDirections.actionProfileFragmentToWishListFragment();
                navController.navigate(direction);
                break;
            case "My Cards":
                direction = ProfileFragmentDirections.actionProfileFragmentToMyCardsFragment();
                navController.navigate(direction);
                break;
            case "My Address":
                direction = ProfileFragmentDirections.actionProfileFragmentToMyAddressFragment();
                navController.navigate(direction);
                break;
            case "Help Center":
                direction = ProfileFragmentDirections.actionProfileFragmentToHelpCenterFragment();
                navController.navigate(direction);
                break;
            /*case "Rate the App":
                openRateDialog();
                break;
            case "Choose Language":
                direction = ProfileFragmentDirections.actionProfileFragmentToChooseLanguageFragment();
                navController.navigate(direction);
                break;
            case "Notification Preference":
                direction = ProfileFragmentDirections.actionProfileFragmentToNotificationFragment();
                navController.navigate(direction);
                break;*/
        }
    }
}