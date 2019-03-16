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

public class FragmentNumberal extends Fragment {
    IGetLinks iGetLinks;
    LinearLayout ln_cardinal_numberals,ln_general_information,ln_numberals_in_sentence,ln_ordinal_numberals;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_numberal, container, false);
        ln_cardinal_numberals = view.findViewById(R.id.ln_cardinal_numberals);
        ln_general_information = view.findViewById(R.id.ln_general_information);
        ln_numberals_in_sentence = view.findViewById(R.id.ln_numberals_in_sentence);
        ln_ordinal_numberals = view.findViewById(R.id.ln_ordinal_numberals);
        getActivity().setTitle("Russian English");
        ln_cardinal_numberals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("numberal/cardinal_numberals.html");
            }
        });
        ln_general_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("numberal/general_information.html");
            }
        });
        ln_numberals_in_sentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("numberal/numberals_in_sentence.html");
            }
        });
        ln_ordinal_numberals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("numberal/ordinal_numberals.html");
            }
        });
        return view;
    }
    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }

}
