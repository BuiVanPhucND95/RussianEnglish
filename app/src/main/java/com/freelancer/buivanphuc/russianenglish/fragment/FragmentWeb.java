package com.freelancer.buivanphuc.russianenglish.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.freelancer.buivanphuc.russianenglish.R;

public class FragmentWeb extends Fragment {
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_web, container, false);
        webView = view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://translate.google.com/#ja/en/text_to_translate");
        //webView.loadUrl("https://techmaster.vn/posts/1539/lap-trinh-ung-dung-android-co-ban");
        webView.requestFocus();
        return view;
    }
}
