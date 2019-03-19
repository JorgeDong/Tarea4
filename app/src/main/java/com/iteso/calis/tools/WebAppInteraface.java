package com.iteso.calis.tools;

import android.content.Context;
import android.widget.Toast;

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