package com.freelancer.buivanphuc.russianenglish.activity;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.freelancer.buivanphuc.russianenglish.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class GrammarActivity extends AppCompatActivity {
    WebView htmlWebView;
    String sLink = "";
    Toolbar toolbar;
    String sTitle;
    public static  boolean sCheckGrammarActivity = false;
    public static boolean sStopActivity = false;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
        htmlWebView = findViewById(R.id.webView);
        toolbar = findViewById(R.id.toolbar);
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);
        sLink = getIntent().getStringExtra("link");
        sTitle = getIntent().getStringExtra("title");
        toolbar.setTitle(sTitle);
        AssetManager mgr = getBaseContext().getAssets();
        try {
            if (!sLink.isEmpty()) {
                InputStream in = mgr.open(sLink, AssetManager.ACCESS_BUFFER);
                String htmlContentInStringFormat = StreamToString(in);
                in.close();
                htmlWebView.loadDataWithBaseURL(null, htmlContentInStringFormat, "text/html", "utf-8", null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        return;
    }

    public static String StreamToString(InputStream in) throws IOException {
        if (in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sCheckGrammarActivity = true;
    }
}
