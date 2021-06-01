package com.example.buddyy;

import java.util.List;

public class Posts {
    private String title ;
    private String description;
    private List<String> tags;
    private List<String> comments;
    private int likes;
    private String user;

    public Posts() {
    }

    public Posts(String title, String description, List<String> tags, List<String> comments, int likes, String user) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.comments = comments;
        this.likes = likes;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> getComments() {
        return comments;
    }

    public int getLikes() {
        return likes;
    }

    public String getUser() {
        return user;
    }
}
