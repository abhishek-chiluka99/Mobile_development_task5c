package com.example.myyoutube_player;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        Intent details = getIntent();
        String link = details.getStringExtra("url").toString().trim();
        WebView webView = findViewById(R.id.webview);
        Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        //String video = "<iframe width=\"100%\" height=\"100%\" src=" + link +" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
//        Log.i("link", "value"+ video);
//        webView.loadData(video,"text/html","utf-8");
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebChromeClient(new WebChromeClient());
            startActivity(webintent);


    }
}