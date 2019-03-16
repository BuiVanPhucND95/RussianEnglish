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

public class FragmentPreposition extends Fragment {
    IGetLinks iGetLinks;
    LinearLayout ln_frequently_used,ln_general_information,ln_preposition_in_sentence;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_preposition, container, false);
        ln_frequently_used = view.findViewById(R.id.ln_frequently_used);
        ln_general_information = view.findViewById(R.id.ln_general_information);
        ln_preposition_in_sentence = view.findViewById(R.id.ln_preposition_in_sentence);
        getActivity().setTitle("Russian English");
        ln_frequently_used.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("preposition/frequently_used.html");
            }
        });
        ln_general_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("preposition/general_information.html");
            }
        });
        ln_preposition_in_sentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("preposition/preposition_in_sentence.html");
            }
        });
        return view;
    }

    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }

}
