package com.example.shubham.pingar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web_page extends AppCompatActivity {
private WebView webpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);
        webpage = (WebView)findViewById(R.id.page);
        WebSettings webSettings = webpage.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webpage.loadUrl("https://drive.google.com/open?id=1g6hdrJubb5AVAmmbgN0mQ4XUUAA&usp=sharing");      //https://drive.google.com/open?id=1g6hdrJubb5AVAmmbgN0mQ4XUUAA&usp=sharing
        webpage.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(webpage.canGoBack())
            webpage.goBack();
        else
        super.onBackPressed();
    }
}
