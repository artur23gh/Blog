package blog.model;


import blog.Category;

import java.util.Date;
import java.util.Objects;

public class Post {

    public Post(String title, String text, Category category) {
        this.title = title;
        this.text = text;
        postCategory = category;
    }

    private String title;
    private String text;
    private Category postCategory;
    private Date createDate = new Date();


    public void setPostCategory(String category) {

        try {
            this.postCategory = Category.valueOf(category);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("there is not post category like"
                    + " \" " + category + " \" " + "\n"
                    + "maybe the problem is in uppercase or lowercase" );
        }

    }

    public void setPostCategory(Category category) {
        this.postCategory = category;
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

    public Category getCategory() {
        return postCategory;
    }

    public String getCategoryAsString() {
        return postCategory.toString();
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
                ", postCategory=" + postCategory +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(text, post.text) &&
                postCategory == post.postCategory &&
                Objects.equals(createDate, post.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, postCategory, createDate);
    }
}