package com.spacestem.ecart.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Utilities {

    public static final String AppName = "ECart Demo";
    public static final int SnackBar_Short = Snackbar.LENGTH_SHORT;
    public static final int Toast_Short = Toast.LENGTH_SHORT;
    public static ProgressDialog progressDialog;

    public static void displaySnackBar(View layout, String message, int duration, int color) {
        final Snackbar snackbar = Snackbar.make(layout, message, duration);
        snackbar.setAction("dismiss", v -> snackbar.dismiss());
        snackbar.setActionTextColor(color);
        snackbar.show();
    }

    public static void displayToast(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    public static void showProgress(Context context, String title, String message) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public static void dismissProgress() {
        progressDialog.dismiss();
    }
}
