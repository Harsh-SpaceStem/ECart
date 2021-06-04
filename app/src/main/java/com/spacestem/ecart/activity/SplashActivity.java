package com.spacestem.ecart.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.spacestem.ecart.R;
import com.spacestem.ecart.utils.PreferenceManager;

public class SplashActivity extends AppCompatActivity {

    ImageView splashImage;
    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        preferenceManager = new PreferenceManager(this);

        splashImage = findViewById(R.id.img_splash);

        new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (preferenceManager.isLogin()) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                }
                finish();
            }
        }).start();
    }
}