package com.company;

public interface PostStorage {

    void add(Post post);
    Post getPostByTitle(String title) throws PostNotFoundException;
    void searchPostsByKeyword (String keyword)  throws PostNotFoundException;
    void printPostsByCategory (Category category) throws PostNotFoundException;
    void printAllPosts();
    boolean isEmpty();

}
