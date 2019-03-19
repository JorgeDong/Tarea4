package com.iteso.calis;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ActivityPrivacyPolicy extends AppCompatActivity implements DialogInterface.OnKeyListener {

    protected WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        webView = findViewById(R.id.activity_privacy_policy_webView);
        webView.loadUrl("file:///android_asset/PrivacyPolicy.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInteraface(this), "Android");
        webView.setWebViewClient(new WebViewClient());
    }


    public class WebAppInteraface {
        Context mContext;
        WebAppInteraface(Context context){
            mContext = context;
        }

        @android.webkit.JavascriptInterface
        public void showToast(String toast){
            Toast.makeText(mContext, toast, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
