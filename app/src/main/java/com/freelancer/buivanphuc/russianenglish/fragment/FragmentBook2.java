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

public class FragmentBook2 extends Fragment implements View.OnClickListener {
    LinearLayout ln_about_me, ln_colours, ln_conversation, ln_entertainment, ln_foody_and_drinks;
    LinearLayout ln_general_expressions, ln_health, ln_hotel, in_guest, ln_in_the_city, ln_inscriptions_and_signs;
    LinearLayout ln_journey, ln_money_business, ln_numbers, ln_phone_mail, ln_problems, ln_questions, ln_services;
    LinearLayout ln_shopping, ln_sport, ln_time_and_date, ln_tour, ln_transport, ln_trip, ln_weather;
    IGetLinks iGetLinks;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_book2, container, false);
        ln_about_me = view.findViewById(R.id.ln_about_me);
        ln_colours = view.findViewById(R.id.ln_colours);
        ln_conversation = view.findViewById(R.id.ln_conversation);
        ln_entertainment = view.findViewById(R.id.ln_entertainment);
        ln_foody_and_drinks = view.findViewById(R.id.ln_foody_and_drinks);
        ln_general_expressions = view.findViewById(R.id.ln_general_expressions);
        ln_health = view.findViewById(R.id.ln_health);
        ln_hotel = view.findViewById(R.id.ln_hotel);

        in_guest = view.findViewById(R.id.in_guest);
        ln_in_the_city = view.findViewById(R.id.ln_in_the_city);
        ln_inscriptions_and_signs = view.findViewById(R.id.ln_inscriptions_and_signs);
        ln_journey = view.findViewById(R.id.ln_journey);
        ln_shopping = view.findViewById(R.id.ln_shopping);
        ln_sport = view.findViewById(R.id.ln_sport);
        ln_time_and_date = view.findViewById(R.id.ln_time_and_date);
        ln_tour = view.findViewById(R.id.ln_tour);
        ln_transport = view.findViewById(R.id.ln_transport);
        ln_trip = view.findViewById(R.id.ln_trip);
        ln_weather = view.findViewById(R.id.ln_weather);
        ln_money_business = view.findViewById(R.id.ln_money_business);
        ln_numbers = view.findViewById(R.id.ln_numbers);
        ln_phone_mail = view.findViewById(R.id.ln_phone_mail);
        ln_problems = view.findViewById(R.id.ln_problems);
        ln_questions = view.findViewById(R.id.ln_questions);
        ln_services = view.findViewById(R.id.ln_services);


        ln_about_me.setOnClickListener(this);
        ln_colours.setOnClickListener(this);
        ln_conversation.setOnClickListener(this);
        ln_entertainment.setOnClickListener(this);
        ln_foody_and_drinks.setOnClickListener(this);
        ln_general_expressions.setOnClickListener(this);
        ln_health.setOnClickListener(this);
        ln_hotel.setOnClickListener(this);
        ln_sport.setOnClickListener(this);
        in_guest.setOnClickListener(this);
        ln_in_the_city.setOnClickListener(this);
        ln_inscriptions_and_signs.setOnClickListener(this);
        ln_journey.setOnClickListener(this);
        ln_shopping.setOnClickListener(this);
        ln_time_and_date.setOnClickListener(this);
        ln_tour.setOnClickListener(this);
        ln_transport.setOnClickListener(this);
        ln_trip.setOnClickListener(this);
        ln_weather.setOnClickListener(this);
        ln_money_business.setOnClickListener(this);
        ln_numbers.setOnClickListener(this);
        ln_phone_mail.setOnClickListener(this);
        ln_problems.setOnClickListener(this);
        ln_questions.setOnClickListener(this);
        ln_services.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ln_about_me:
                iGetLinks.getLink("book2/about_me.html");
                break;
            case R.id.ln_colours:
                iGetLinks.getLink("book2/colours.html");
                break;
            case R.id.ln_conversation:
                iGetLinks.getLink("book2/conversation.html");
                break;
            case R.id.ln_entertainment:
                iGetLinks.getLink("book2/entertainment.html");
                break;
            case R.id.ln_foody_and_drinks:
                iGetLinks.getLink("book2/food_and_drinks.html");
                break;
            case R.id.ln_general_expressions:
                iGetLinks.getLink("book2/general_expressions.html");
                break;
            case R.id.ln_health:
                iGetLinks.getLink("book2/health.html");
                break;
            case R.id.ln_hotel:
                iGetLinks.getLink("book2/hotel.html");
                break;
            case R.id.in_guest:
                iGetLinks.getLink("book2/in_guests.html");
                break;
            case R.id.ln_in_the_city:
                iGetLinks.getLink("book2/in_the_city.html");
                break;
            case R.id.ln_inscriptions_and_signs:
                iGetLinks.getLink("book2/inscriptions_and_signs.html");
                break;
            case R.id.ln_journey:
                iGetLinks.getLink("book2/journey.html");
                break;
            case R.id.ln_shopping:
                iGetLinks.getLink("book2/shopping.html");
                break;
            case R.id.ln_time_and_date:
                iGetLinks.getLink("book2/time_and_date.html");
                break;
            case R.id.ln_tour:
                iGetLinks.getLink("book2/tour.html");
                break;
            case R.id.ln_transport:
                iGetLinks.getLink("book2/transport.html");
                break;
            case R.id.ln_trip:
                iGetLinks.getLink("book2/trip.html");
                break;
            case R.id.ln_weather:
                iGetLinks.getLink("book2/weather.html");
                break;
            case R.id.ln_money_business:
                iGetLinks.getLink("book2/money_business.html");
                break;
            case R.id.ln_numbers:
                iGetLinks.getLink("book2/numbers.html");
                break;
            case R.id.ln_phone_mail:
                iGetLinks.getLink("book2/phone_mail.html");
                break;
            case R.id.ln_problems:
                iGetLinks.getLink("book2/problems.html");
                break;
            case R.id.ln_questions:
                iGetLinks.getLink("book2/questions.html");
                break;
            case R.id.ln_services:
                iGetLinks.getLink("book2/services.html");
                break;
            case R.id.ln_sport:
                iGetLinks.getLink("book2/sport.html");
                break;
        }
    }
    public void setInterface(IGetLinks iGetLinks) {
        this.iGetLinks = iGetLinks;
    }
}
