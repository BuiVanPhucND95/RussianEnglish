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

public class FragmentNouns extends Fragment {
    LinearLayout lnGeneral_information, lnPlurals, lnNouns_sentence;
    IGetLinks iGetLinks;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_nouns, container, false);
        lnGeneral_information = view.findViewById(R.id.lnGeneral_information);
        lnPlurals = view.findViewById(R.id.lnPlurals);
        lnNouns_sentence = view.findViewById(R.id.lnNouns_sentence);
        getActivity().setTitle("Russian English");
        lnGeneral_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("noun/general_information.html");
            }
        });
        lnPlurals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("noun/plurals.html");
            }
        });
        lnNouns_sentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("noun/nouns_in_sentence.html");
            }
        });
        return view;
    }

    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }

}
