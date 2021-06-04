package com.spacestem.ecart.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class PreferenceManager {
    private final String UserPreference = "UserDetail";
    Context context;

    public PreferenceManager(Context context) {
        this.context = context;
    }

    public void clearLoginDetails() {
        SharedPreferences preferences = context.getSharedPreferences(UserPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
    }

    public boolean isLogin() {
        SharedPreferences preferences = context.getSharedPreferences(UserPreference, MODE_PRIVATE);
        String phoneNumber = preferences.getString("email", null);
        return phoneNumber != null;
    }

    public void saveLogin(String email) {
        SharedPreferences preferences = context.getSharedPreferences(UserPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", email);
        editor.apply();
        editor.commit();
    }

    public void saveUserDetails(String name, String email, String phone) {
        SharedPreferences preferences = context.getSharedPreferences(UserPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", email);
        editor.putString("name", name);
        editor.putString("phone", phone);
        editor.apply();
        editor.commit();
    }

    public List<String> getUserDetails() {
        List<String> userList = new ArrayList<>();
        SharedPreferences preferences = context.getSharedPreferences(UserPreference, MODE_PRIVATE);
        String email = preferences.getString("email", null);
        String name = preferences.getString("name", null);
        String phone = preferences.getString("phone", null);
        userList.add(email);
        userList.add(name);
        userList.add(phone);
        return userList;
    }
}
