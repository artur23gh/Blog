package blog.storage;


import blog.Category;
import blog.exception.PostNotFoundException;
import blog.model.Post;

public interface PostStorage {

    void add(Post post);
    Post getPostByTitle(String title) throws PostNotFoundException;
    void searchPostsByKeyword (String keyword)  throws PostNotFoundException;
    void printPostsByCategory (Category category) throws PostNotFoundException;
    void printAllPosts() throws PostNotFoundException;
    boolean isEmpty();

}