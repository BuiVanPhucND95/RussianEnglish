package com.freelancer.buivanphuc.russianenglish.dto;

public class WordsDTO {
    private int id;
    private String word;
    private String definition;
    private String status;
    private String userCreated;

    public WordsDTO() {

    }

    public WordsDTO(int id, String word, String definition, String status, String userCreated) {
        this.id = id;
        this.word = word;
        this.definition = definition;
        this.status = status;
        this.userCreated = userCreated;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }
}
