package com.example.monkey.myapplication;

/**
 * Created by wangfanghua on 2018/1/18.
 */

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.support.design.widget.Snackbar;
import android.webkit.WebView;

public class MonkeyFragment extends Fragment {
    public static MonkeyFragment newInstance(String info) {
        Bundle args = new Bundle();
        MonkeyFragment fragment = new MonkeyFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monkey_view, null);
        WebView webView = view.findViewById(R.id.mkWebView);
        webView.loadUrl("https://www.baidu.com");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        return view;
    }
}
