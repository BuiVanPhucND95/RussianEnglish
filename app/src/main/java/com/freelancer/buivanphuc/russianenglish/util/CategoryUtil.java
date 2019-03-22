package com.freelancer.buivanphuc.russianenglish.util;

import com.freelancer.buivanphuc.russianenglish.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryUtil {
    public static List<CategoryDTO> addNouns() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "noun/general_information.html", "Nouns"));
        list.add(new CategoryDTO("Plurals", "noun/plurals.html", "Nouns"));
        list.add(new CategoryDTO("Nouns in Sentence", "noun/nouns_in_sentence.html", "Nouns"));
        return list;
    }

    public static List<CategoryDTO> addArticle() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("Indefinite Article", "article/indefinite_article.html", "Article"));
        list.add(new CategoryDTO("Indefinite Article", "article/definite_article.html", "Article"));
        list.add(new CategoryDTO("No Article", "article/no_article.html", "Article"));
        return list;
    }

    public static List<CategoryDTO> addPronoun() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "pronoun/general_information.html", "Pronoun"));
        list.add(new CategoryDTO("The Use of Pronouns", "pronoun/the_use_of_pronouns.html", "Pronoun"));
        list.add(new CategoryDTO("Pronouns in Sentence", "pronoun/pronouns_in_sentence.html", "Pronoun"));
        return list;
    }

    public static List<CategoryDTO> addNumberal() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "numberal/general_information.html", "Numberal"));
        list.add(new CategoryDTO("Cardinal Numberals", "numberal/cardinal_numberals.html", "Numberal"));
        list.add(new CategoryDTO("Ordinal Numberals", "numberal/ordinal_numberals.html", "Numberal"));
        list.add(new CategoryDTO("Numberals in Sentence", "numberal/numberals_in_sentence.html", "Numberal"));

        return list;
    }

    public static List<CategoryDTO> addAdjective() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "adjective/general_information.html", "Adjective"));
        list.add(new CategoryDTO("Degress of comparison", "adjective/degrees_of_comparison.html", "Adjective"));
        list.add(new CategoryDTO("Adjective in Sentence", "adjective_in_sentence.html", "Adjective"));

        return list;
    }

    public static List<CategoryDTO> addAdverb() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "adjective/general_information.html", "Adverb"));
        list.add(new CategoryDTO("Degress of comparison", "adverb/degrees_of_comparison.html", "Adverb"));
        list.add(new CategoryDTO("Classification of Adverbs", "adverb/classification_of_adverbs.html", "Adverb"));
        list.add(new CategoryDTO("Adverbs in Sentence", "adverb/adverb_in_sentence.html", "Adverb"));

        return list;
    }

    public static List<CategoryDTO> addVerb() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "verb/general_information.html", "Verb"));
        list.add(new CategoryDTO("Personal/impersonal Verb", "verb/person_and_number.html", "Verb"));
        list.add(new CategoryDTO("Regular/Irregular Verb", "verb/personal_impersonal_verbs.html", "Verb"));
        list.add(new CategoryDTO("Transitive/Lntransitive Verbs", "verb/regular_irregular_verbs.html", "Verb"));
        list.add(new CategoryDTO("Transitive/intransitive verbs", "verb/transitive_intransitive_verbs.html", "Verb"));

        return list;
    }

    public static List<CategoryDTO> addPreposition() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "preposition/general_information.html", "Preposition"));
        list.add(new CategoryDTO("Frequently Used", "preposition/frequently_used.html", "Preposition"));
        list.add(new CategoryDTO("Prepposition in Sentence", "preposition/preposition_in_sentence.html", "Preposition"));
        return list;
    }

    public static List<CategoryDTO> addConjunction() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "conjunction/general_information.html", "Conjunction"));
        list.add(new CategoryDTO("Coordinative Conjunctions", "conjunction/coordinative_conjunctions.html", "Conjunction"));
        list.add(new CategoryDTO("Subordinative Conjunctions", "conjunction/subordinative_conjunctions.html", "Conjunction"));
        return list;

    }

    public static List<CategoryDTO> addParticles() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "particles/general_information.html", "Particles"));
        list.add(new CategoryDTO("Difference of Particles", "particles/difference_of_particles.html", "Particles"));
        return list;
    }

    public static List<CategoryDTO> addInterjection() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("General Infomation", "interjection/general_information.html", "Particles"));
        return list;
    }

    public static List<CategoryDTO> addBookOne() {
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("Bank money", "book1/bank_money.html", "Book1"));
        list.add(new CategoryDTO("Business Communitcation", "book1/business_communication.html", "Book1"));
        list.add(new CategoryDTO("Cafe Restaurant", "book1/cafe_restaurant.html", "Book1"));
        list.add(new CategoryDTO("City Transport", "book1/city_transport.html", "Book1"));
        list.add(new CategoryDTO("Common Phrases", "book1/common_phrases.html", "Book1"));
        list.add(new CategoryDTO("Entertainment Sport", "book1/entertainment_sport.html", "Book1"));
        list.add(new CategoryDTO("Health", "book1/health.html", "Book1"));
        list.add(new CategoryDTO("Hotel Service", "book1/hotel_service.html", "Book1"));
        list.add(new CategoryDTO("meeting communication", "book1/meeting_communication.html", "Book1"));
        list.add(new CategoryDTO("Miscellaneous", "book1/miscellaneous.html", "Book1"));
        list.add(new CategoryDTO("Problems", "book1/problems.html", "Book1"));
        list.add(new CategoryDTO("Shopping", "book1/shopping.html", "Book1"));
        list.add(new CategoryDTO("Telephone Mail", "book1/telephone_mail.html", "Book1"));
        list.add(new CategoryDTO("Trip Journey ", "book1/trip_journey.html", "Book1"));
        return list;
    }
    public static List<CategoryDTO> addBookTwo(){
        List<CategoryDTO> list = new ArrayList<>();
        list.add(new CategoryDTO("About Me", "book2/about_me.html","Book2"));
        list.add(new CategoryDTO("Colours", "book2/colours.html","Book2"));
        list.add(new CategoryDTO("Conversation", "book2/conversation.html","Book2"));
        list.add(new CategoryDTO("Entertainment", "book2/Entertainment.html","Book2"));
        list.add(new CategoryDTO("Food and Drinks", "book2/food_and_drinks.html","Book2"));
        list.add(new CategoryDTO("General Expressions", "book2/general_expressions.html","Book2"));
        list.add(new CategoryDTO("Health", "book2/health.html","Book2"));
        list.add(new CategoryDTO("In Guests", "book2/in_guests.html","Book2"));
        list.add(new CategoryDTO("In the city", "book2/in_the_city.html","Book2"));
        list.add(new CategoryDTO("Journey", "book2/journey.html","Book2"));
        list.add(new CategoryDTO("shopping", "book2/shopping.html","Book2"));
        list.add(new CategoryDTO("Time and Date", "book2/time_and_date.html","Book2"));
        list.add(new CategoryDTO("Tour", "book2/tour.html","Book2"));
        list.add(new CategoryDTO("Transport", "book2/transport.html","Book2"));
        list.add(new CategoryDTO("Trip", "book2/trip.html","Book2"));
        list.add(new CategoryDTO("Weather", "book2/weather.html","Book2"));
        list.add(new CategoryDTO("money business", "book2/money_business.html","Book2"));
        list.add(new CategoryDTO("Numbers", "book2/numbers.html","Book2"));
        list.add(new CategoryDTO("phone mail", "book2/phone_mail.html","Book2"));
        list.add(new CategoryDTO("Problems", "book2/problems.html","Book2"));
        list.add(new CategoryDTO("Questions", "book2/questions.html","Book2"));
        list.add(new CategoryDTO("Services", "book2/services.html","Book2"));
        list.add(new CategoryDTO("Sport", "book2/sport.html","Book2"));

        return list;
    }
}
