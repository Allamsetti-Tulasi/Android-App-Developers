package com.example.intentsapp_abr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText2;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit3);
        webView = findViewById(R.id.web1);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    public void secondScreen(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void browser(View view) {
        String data = editText.getText().toString();
        Uri uri = Uri.parse("https://www."+data);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    public void sendData(View view) {
        String name = editText2.getText().toString();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("KEY",name);
        startActivity(intent);
    }
}