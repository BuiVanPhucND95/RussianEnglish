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

public class FragmentConjunction extends Fragment {
    LinearLayout ln_coordinative_conjunctions, ln_general_information, ln_subordinative_conjunctions;
    IGetLinks iGetLinks;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_conjunction, container, false);
        ln_coordinative_conjunctions = view.findViewById(R.id.ln_coordinative_conjunctions);
        ln_general_information = view.findViewById(R.id.ln_general_information);
        ln_subordinative_conjunctions = view.findViewById(R.id.ln_subordinative_conjunctions);
        getActivity().setTitle("Russian English");
        ln_coordinative_conjunctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("conjunction/coordinative_conjunctions.html");
            }
        });
        ln_general_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("conjunction/general_information.html");
            }
        });
        ln_subordinative_conjunctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("conjunction/subordinative_conjunctions.html");
            }
        });
        return view;
    }

    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }

}
