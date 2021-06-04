package com.spacestem.ecart.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.spacestem.ecart.R;
import com.spacestem.ecart.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigationView;
    NavController navController;
    Toolbar toolbar;
    NavHostFragment fragment;
    boolean backPress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottom_navigationView = findViewById(R.id.bottom_navigationView);
        fragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (fragment != null) {
            navController = fragment.getNavController();
        }

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment,
                R.id.shopByCategoryFragment,
                R.id.searchFragment,
                R.id.cartFragment,
                R.id.profileFragment).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottom_navigationView, navController);
    }

    @Override
    public void onBackPressed() {
        final Fragment currentFragment = fragment.getChildFragmentManager().getFragments().get(0);
        final NavController controller = Navigation.findNavController(this, R.id.nav_host_fragment);
        if (currentFragment instanceof HomeFragment) {
            if (backPress) {
                finish();
            } else {
                backPress = true;
                Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(() -> backPress = false, 2000);
            }
        } else if (!controller.popBackStack())
            finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}