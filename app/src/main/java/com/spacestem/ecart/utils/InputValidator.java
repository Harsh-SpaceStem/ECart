package com.spacestem.ecart.utils;

import android.content.Context;
import android.text.TextUtils;

import androidx.appcompat.content.res.AppCompatResources;

import com.google.android.material.textfield.TextInputLayout;
import com.spacestem.ecart.R;

public class InputValidator {

    private static final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static boolean validateEmail(Context context, String email, TextInputLayout layout) {
        if (TextUtils.isEmpty(email)) {
            layout.setHelperText("Email is Require !");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.colorSecondary));
            return false;
        } else if (!email.matches(emailPattern)) {
            layout.setHelperText("Invalid Format !");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else {
            layout.setHelperText(null);
            return true;
        }
    }

    public static boolean validatePassword(Context context, String password, TextInputLayout layout) {
        if (TextUtils.isEmpty(password)) {
            layout.setHelperText("Password Require !");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else if (password.length() < 8) {
            layout.setHelperText("password contains atLeast 8 characters");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else {
            layout.setHelperText(null);
            return true;
        }
    }

    public static boolean validatePasswordForRegistration(Context context, String password, TextInputLayout layout) {
        if (TextUtils.isEmpty(password)) {
            layout.setHelperText("Password Require !");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else if (password.length() < 8) {
            layout.setHelperText("password contains atLeast 8 characters");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else if (!password.matches(passwordPattern)) {
            layout.setHelperText("password must be Strong !");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else {
            layout.setHelperText(null);
            return true;
        }
    }

    public static boolean validateName(Context context, String name, TextInputLayout layout) {
        if (TextUtils.isEmpty(name)) {
            layout.setHelperText("UserName is Required !");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else {
            layout.setHelperText(null);
            return true;
        }
    }

    public static boolean validateConfirmPassword(Context context, String cnfPassword, String password, TextInputLayout cnfPasswordLayout) {
        if (TextUtils.isEmpty(cnfPassword)) {
            cnfPasswordLayout.setHelperText("Password Require !");
            cnfPasswordLayout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else if (!TextUtils.equals(cnfPassword, password)) {
            cnfPasswordLayout.setHelperText("Password Not Matches !");
            cnfPasswordLayout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else {
            cnfPasswordLayout.setHelperText(null);
            return true;
        }
    }

    public static boolean validatePhone(Context context, String phone, TextInputLayout layout) {
        if (TextUtils.isEmpty(phone)) {
            layout.setHelperText("Phone number is Require !");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else if (phone.length() < 10) {
            layout.setHelperText("Invalid Phone Number !");
            layout.setHelperTextColor(AppCompatResources.getColorStateList(context, R.color.error));
            return false;
        } else {
            layout.setHelperText(null);
            return true;
        }
    }
}
