package com.harish.webtoapptemplate;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.KeyEvent;
//import android.view.View;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.widget.ImageButton;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//
//public class MainActivity extends AppCompatActivity {
//     //  WebView webView;
//
//
//    private WebView webView;
////
////    @Override
////    public void onBackPressed() {
////        if (webView.canGoBack()) {
////            webView.goBack();
////        } else {
////            new AlertDialog.Builder(this)
////                    .setTitle("Confirm Exit")
////                    .setMessage("Are you sure you want to exit?")
////                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
////                        @Override
////                        public void onClick(DialogInterface dialog, int which) {
////                            // perform default back button action (exit app)
////                            MainActivity.super.onBackPressed();
////                        }
////                    })
////                    .setNegativeButton("No", null)
////                    .show();
////        }
////    }
//
//
//
//
//    private boolean backPressedOnce = false;
//
//    @Override
//    public void onBackPressed() {
//        if (backPressedOnce) {
//            super.onBackPressed();
//            return;
//        }
//
//        this.backPressedOnce = true;
//        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                backPressedOnce = false;
//            }
//        }, 2000); // Set your desired delay time here
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        WebView webView = (WebView) findViewById(R.id.web_view);
//        //webView=(WebView)findViewById(R.id.web_view1);
//        WebViewClient webViewClient = new WebViewClient();
//        webView.setWebViewClient(webViewClient);
//        webView.loadUrl("https://groupempire.github.io/lnmhack/");
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//
//        //backbutton code
//
//
//
//
//
//    }
//
//
//   //ending of  mainactvity class
//}


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    private int keyCode;
    private KeyEvent event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.web_view);
        WebViewClient webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);
        webView.loadUrl("http://hpnews.ml");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl("http://hpnews.ml");
//we als addded the back graffic button
        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                }
            }
        });

    }

    //cooment the direct  the direct exit button
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        this.keyCode = keyCode;
//        this.event = event;
//        if (event.getAction() == KeyEvent.ACTION_DOWN) {
//            switch (keyCode) {
//                case KeyEvent.KEYCODE_BACK:
//                    if (webView.canGoBack()) {
//                        webView.goBack();
//                    } else {
//                        finish();
//                    }
//                    return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//}
    //prcompt open before exiting ask you for confirm exiting
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Confirm Exit")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // perform default back button action (exit app)
                            MainActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }
}

