package com.freelancer.buivanphuc.russianenglish.dto;

public class FavoretisDTO {
    private int id;
    private String word;
    private String definition;

    public FavoretisDTO(){

    }
    public FavoretisDTO(int id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
