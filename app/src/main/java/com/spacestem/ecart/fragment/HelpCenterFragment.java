package com.spacestem.ecart.fragment;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.spacestem.ecart.R;

public class HelpCenterFragment extends Fragment {

    WebView webView;
    ProgressBar progressBar;

    public HelpCenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help_center, container, false);
        initView(view);
        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView(View view) {

        progressBar = view.findViewById(R.id.webProgressbar);
        webView = view.findViewById(R.id.webView);

        String webUrl = "https://www.google.com/";
        webView.loadUrl(webUrl);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

    }

}