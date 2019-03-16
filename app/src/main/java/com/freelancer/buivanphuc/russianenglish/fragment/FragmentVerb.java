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

public class FragmentVerb extends Fragment implements View.OnClickListener {
    IGetLinks iGetLinks;
    LinearLayout lngeneral_information, ln_person_and_number, ln_personal_impersonal_verbs;
    LinearLayout ln_regular_irregular_verbs, ln_transitive_intransitive_verbs, ln_Other;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_verb, container, false);
        lngeneral_information = view.findViewById(R.id.lngeneral_information);
        ln_person_and_number = view.findViewById(R.id.ln_person_and_number);
        ln_personal_impersonal_verbs = view.findViewById(R.id.ln_personal_impersonal_verbs);
        ln_regular_irregular_verbs = view.findViewById(R.id.ln_regular_irregular_verbs);
        ln_transitive_intransitive_verbs = view.findViewById(R.id.ln_transitive_intransitive_verbs);
        ln_Other = view.findViewById(R.id.ln_Other);
        getActivity().setTitle("Russian English");

        lngeneral_information.setOnClickListener(this);
        ln_person_and_number.setOnClickListener(this);
        ln_personal_impersonal_verbs.setOnClickListener(this);
        ln_regular_irregular_verbs.setOnClickListener(this);
        ln_transitive_intransitive_verbs.setOnClickListener(this);
        ln_Other.setOnClickListener(this);
        return view;
    }

    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.lngeneral_information:
                iGetLinks.getLink("verb/general_information.html");
                break;
            case R.id.ln_person_and_number:
                iGetLinks.getLink("verb/person_and_number.html");
                break;
            case R.id.ln_personal_impersonal_verbs:
                iGetLinks.getLink("verb/personal_impersonal_verbs.html");
                break;
            case R.id.ln_regular_irregular_verbs:
                iGetLinks.getLink("verb/regular_irregular_verbs.html");
                break;
            case R.id.ln_transitive_intransitive_verbs:
                iGetLinks.getLink("verb/transitive_intransitive_verbs.html");
                break;
            case R.id.ln_Other:
                iGetLinks.getLink("verb/other.html");
                break;
        }
    }
}
