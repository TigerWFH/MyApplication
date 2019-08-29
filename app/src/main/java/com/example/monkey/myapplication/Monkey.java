package com.example.monkey.myapplication;

/**
 * Created by wangfanghua on 2018/1/18.
 */

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebView;

// 参考资料：https://blog.csdn.net/carson_ho/article/details/52693322
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
                System.out.println("***********onPageStarted:begin loading1***********:" + url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                System.out.println("***********onLoadResource***********:" + url);
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                System.out.println("***********onPageFinished:end loading3***********" + url);
                super.onPageFinished(view, url);
            }

//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                System.out.println("***********shouldOverrideUrlLoading2***********" + request);
////                return super.shouldOverrideUrlLoading(view, request);
//                return true;
//            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                System.out.println("***********onReceivedError***********");
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                System.out.println("***********onReceivedSslError***********");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println("***********shouldOverrideUrlLoading***********" + url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webView.setWebContentsDebuggingEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
//        webView.loadUrl("https://www.test.pajkdc.com/mall-falsh/index.html#/addresslist");
        webView.loadUrl("pajk://resource/camera");
//        webView.loadUrl("https://www.test.pajkdc.com/daisy/#/login?appId=513&returnUrl=https:%2F%2Fwww.test.pajkdc.com%2Fmall-flash%2Findex.html%23%2Faddresslist");
        return view;
    }
}
