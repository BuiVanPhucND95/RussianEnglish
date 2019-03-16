package com.freelancer.buivanphuc.russianenglish.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.freelancer.buivanphuc.russianenglish.interfaces.IGetLinks;
import com.freelancer.buivanphuc.russianenglish.R;

public class FragmentArticle extends Fragment {
    LinearLayout lndefinite_artcle, lnIndefind_Article, ln_no_article;
    IGetLinks iGetLinks;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_article, container, false);
        lndefinite_artcle = view.findViewById(R.id.lndefinite_artcle);
        lnIndefind_Article = view.findViewById(R.id.lnIndefind_Article);
        ln_no_article = view.findViewById(R.id.ln_no_article);
        getActivity().setTitle("Russian English");
        lndefinite_artcle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("article/definite_article.html");
            }
        });
        lnIndefind_Article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("article/indefinite_article.html");
            }
        });
        ln_no_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("article/no_article.html");
            }
        });
        return view;

    }
    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }
}
