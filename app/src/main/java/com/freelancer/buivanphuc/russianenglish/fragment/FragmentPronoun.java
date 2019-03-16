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

public class FragmentPronoun extends Fragment {
    LinearLayout lngeneral_information, ln_pronouns_in_sentence, ln_the_use_of_pronouns;
    IGetLinks iGetLinks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_pronoun, container, false);
        lngeneral_information = view.findViewById(R.id.lngeneral_information);
        ln_pronouns_in_sentence = view.findViewById(R.id.ln_pronouns_in_sentence);
        ln_the_use_of_pronouns = view.findViewById(R.id.ln_the_use_of_pronouns);
        getActivity().setTitle("Russian English");
        lngeneral_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("pronoun/general_information.html");
            }
        });
        ln_pronouns_in_sentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("pronoun/pronouns_in_sentence.html");
            }
        });
        ln_the_use_of_pronouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("pronoun/the_use_of_pronouns.html");
            }
        });
        return view;

    }
    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }
}
