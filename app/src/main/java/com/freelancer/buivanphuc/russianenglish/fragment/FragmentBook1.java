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

public class FragmentBook1 extends Fragment implements View.OnClickListener {
    LinearLayout ln_bank_money, ln_business_communication, ln_cafe_restaurant, city_transport, ln_common_phrases;
    LinearLayout ln_entertainment_sport, ln_health, ln_hotel_service, ln_meeting_communication;
    LinearLayout ln_miscellaneous, ln_problems, ln_shopping, ln_telephone_mail, ln_trip_journey;
    IGetLinks iGetLinks;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_book1, container, false);
        ln_bank_money = view.findViewById(R.id.ln_bank_money);
        ln_business_communication = view.findViewById(R.id.ln_business_communication);
        ln_cafe_restaurant = view.findViewById(R.id.ln_cafe_restaurant);
        city_transport = view.findViewById(R.id.city_transport);
        ln_common_phrases = view.findViewById(R.id.ln_common_phrases);
        ln_entertainment_sport = view.findViewById(R.id.ln_entertainment_sport);
        ln_health = view.findViewById(R.id.ln_health);
        ln_hotel_service = view.findViewById(R.id.ln_hotel_service);
        ln_meeting_communication = view.findViewById(R.id.ln_meeting_communication);
        ln_miscellaneous = view.findViewById(R.id.ln_miscellaneous);
        ln_problems = view.findViewById(R.id.ln_problems);
        ln_shopping = view.findViewById(R.id.ln_shopping);
        ln_telephone_mail = view.findViewById(R.id.ln_telephone_mail);
        ln_trip_journey = view.findViewById(R.id.ln_trip_journey);
        getActivity().setTitle("Russian English");

        ln_bank_money.setOnClickListener(this);
        ln_business_communication.setOnClickListener(this);
        ln_cafe_restaurant.setOnClickListener(this);
        city_transport.setOnClickListener(this);
        ln_common_phrases.setOnClickListener(this);
        ln_entertainment_sport.setOnClickListener(this);
        ln_health.setOnClickListener(this);
        ln_hotel_service.setOnClickListener(this);
        ln_meeting_communication.setOnClickListener(this);
        ln_miscellaneous.setOnClickListener(this);
        ln_shopping.setOnClickListener(this);
        ln_telephone_mail.setOnClickListener(this);
        ln_trip_journey.setOnClickListener(this);
        ln_problems.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ln_bank_money:
                iGetLinks.getLink("book1/bank_money.html");
                break;
            case R.id.ln_business_communication:
                iGetLinks.getLink("book1/business_communication.html");
                break;
            case R.id.ln_cafe_restaurant:
                iGetLinks.getLink("book1/cafe_restaurant.html");
                break;
            case R.id.city_transport:
                iGetLinks.getLink("book1/city_transport.html");
                break;
            case R.id.ln_common_phrases:
                iGetLinks.getLink("book1/common_phrases.html");
                break;
            case R.id.ln_entertainment_sport:
                iGetLinks.getLink("book1/entertainment_sport.html");
                break;
            case R.id.ln_health:
                iGetLinks.getLink("book1/health.html");
                break;
            case R.id.ln_hotel_service:
                iGetLinks.getLink("book1/hotel_service.html");
                break;
            case R.id.ln_meeting_communication:
                iGetLinks.getLink("book1/meeting_communication.html");
                break;
            case R.id.ln_miscellaneous:
                iGetLinks.getLink("book1/miscellaneous.html");
                break;
            case R.id.ln_problems:
                iGetLinks.getLink("book1/problems.html");
                break;
            case R.id.ln_shopping:
                iGetLinks.getLink("book1/shopping.html");
                break;
            case R.id.ln_telephone_mail:
                iGetLinks.getLink("book1/telephone_mail.html");
                break;
            case R.id.ln_trip_journey:
                iGetLinks.getLink("book1/trip_journey.html");
                break;
        }
    }
    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }
}
