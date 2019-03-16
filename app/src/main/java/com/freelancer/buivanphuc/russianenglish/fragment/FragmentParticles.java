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

public class FragmentParticles extends Fragment {

    LinearLayout ln_difference_of_particles, ln_general_information;
    IGetLinks iGetLinks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_particles, container, false);
        ln_difference_of_particles = view.findViewById(R.id.ln_difference_of_particles);
        ln_general_information = view.findViewById(R.id.ln_general_information);
        getActivity().setTitle("Russian English");
        ln_difference_of_particles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("particles/difference_of_particles.html");
            }
        });
        ln_general_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetLinks.getLink("particles/general_information.html");
            }
        });
        return view;
    }

    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }
}
