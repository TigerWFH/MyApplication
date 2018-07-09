package com.example.monkey.myapplication;

/**
 * Created by wangfanghua on 2018/1/18.
 */

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebView;

public class Monkey extends Fragment {
    private WebView webView;
    public static Monkey newInstance(String info) {
        Bundle args = new Bundle();
        Monkey fragment = new Monkey();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monkey_view, null);
        webView = view.findViewById(R.id.mkWebView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                System.out.println("***********begin loading***********:" + url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                System.out.println("***********end loading***********" + url);
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                System.out.println("***********shouldOverrideUrlLoading***********" + request);
//                return super.shouldOverrideUrlLoading(view, request);
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println("***********shouldOverrideUrlLoading***********" + url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebContentsDebuggingEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.loadUrl("https://www.baidu.com");
        return view;
    }
}
