package com.freelancer.buivanphuc.russianenglish.dto;

public class CategoryDTO {
    private String name;
    private String link;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryDTO(String name, String link, String title) {
        this.name = name;
        this.link = link;
        this.title = title;
    }

    public CategoryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
