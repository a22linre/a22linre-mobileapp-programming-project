package com.example.mobileapp_programming_project;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        WebView webView = findViewById(R.id.webView);
        webView.loadData("<html><body><h1>About this App</h1><p>This app is designed to display plant information, such as name, category and price. It could be use for online plant shopping.</p></body></html>", "text/html", "UTF-8");
    }
}
