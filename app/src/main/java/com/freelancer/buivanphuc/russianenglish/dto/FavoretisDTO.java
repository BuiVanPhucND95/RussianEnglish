package com.freelancer.buivanphuc.russianenglish.dto;

public class FavoretisDTO {
    private int id;
    private String word;
    private String definition;
    private String status;
    public FavoretisDTO(){

    }
    public FavoretisDTO(int id, String word, String definition,String status) {
        this.id = id;
        this.word = word;
        this.definition = definition;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
