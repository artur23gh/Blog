package com.company;

import java.util.Date;
import java.util.Objects;

public class Post {

    public Post(String title, String text, String category) {
        this.title = title;
        this.text = text;
        this.category = category;
    }

    private String title;
    private String text;
    private String category;
    private Date createDate = new Date();


    public void setCategory(String category) {
        this.category = category;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date  getCreateDate() {
        return createDate;
    }

    public String getCategory() {
        return category;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
