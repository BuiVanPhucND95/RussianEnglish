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

public class FragmentAdverb extends Fragment {
    LinearLayout ln_adverb_in_sentence, ln_classification_of_adverbs, ln_degrees_of_comparison, ln_general_information;
    IGetLinks iGetLinks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_adverb, container, false);
        ln_adverb_in_sentence = view.findViewById(R.id.ln_adverb_in_sentence);
        ln_classification_of_adverbs = view.findViewById(R.id.ln_classification_of_adverbs);
        ln_degrees_of_comparison = view.findViewById(R.id.ln_degrees_of_comparison);
        ln_general_information = view.findViewById(R.id.ln_general_information);
        getActivity().setTitle("Russian English");
        ln_adverb_in_sentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("adverb/adverb_in_sentence.html");
            }
        });
        ln_classification_of_adverbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("adverb/classification_of_adverbs.html");
            }
        });
        ln_degrees_of_comparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("adverb/degrees_of_comparison.html");
            }
        });
        ln_general_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("adverb/general_information.html");
            }
        });
        return view;
    }

    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }

}
