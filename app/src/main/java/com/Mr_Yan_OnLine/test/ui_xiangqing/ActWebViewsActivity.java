package com.Mr_Yan_OnLine.test.ui_xiangqing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.Mr_Yan_OnLine.test.R;

public class ActWebViewsActivity extends Activity {

    private WebView mAct_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_webview);

        Intent intent = getIntent();
        String actImg = intent.getStringExtra("actImg");
        mAct_web = (WebView) findViewById(R.id.act_web);
        WebSettings settings = mAct_web.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        mAct_web.setWebViewClient(new WebViewClient());
        mAct_web.loadUrl(actImg);
    }
}
