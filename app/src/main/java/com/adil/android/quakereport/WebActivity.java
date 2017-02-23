package com.adil.android.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Bundle extras = getIntent().getExtras();
        String url,title;

        title=extras.getString("place");
        setTitle(title);

        if(extras!=null)
        {
         url=extras.getString("url");

            WebView webView = (WebView) findViewById(R.id.WebView);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
        }
    }
}
