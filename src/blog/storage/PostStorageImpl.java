package blog.storage;


import blog.Category;
import blog.exception.PostNotFoundException;
import blog.model.Post;

import java.util.Arrays;

public class PostStorageImpl implements PostStorage {

    private Post[] postsArray = new Post[10];
    int size = 0;


    public void add(Post post) {
        if (size == postsArray.length) {
            extend();
        }
        postsArray[size++] = post;

        System.out.println("the new post is added with this parameters "
                + "( title = " + postsArray[size - 1].getTitle()
                + " , text = " + postsArray[size - 1].getText()
                + " , category = " + postsArray[size - 1].getCategory()
                + " , createDate = " + postsArray[size - 1].getCreateDate() + " )"
        );

    }

    /*
    վերադարձնում ենք Գրառումը ըստ տրված վերնագրի
     */
    public Post getPostByTitle(String title) throws PostNotFoundException {
        if (isEmpty()) {
            throw new PostNotFoundException("you are trying to find post in empty storage");
        }
        for (int i = 0; i < size; i++) {
            if (title.equals(postsArray[i].getTitle())) {
                return postsArray[i];
            }
        }
        throw new PostNotFoundException("Post not found");
    }

    /*
    տպում է գրառումը եթե տրված keyword բառը պարունակում է կամ վերնագրի մեջ,
     կամ տեքստ-ի։(String-ը ունի contains մեթոդը, իրանով երեք)
     */
    public void searchPostsByKeyword(String keyword) throws PostNotFoundException {
        if (isEmpty()) {
            throw new PostNotFoundException("you are trying to find post in empty storage");
        }

        boolean anyPostFound = false;

        for (int i = 0; i < size; i++) {
            String title = postsArray[i].getTitle();
            String text = postsArray[i].getText();
            if (text.contains(keyword) || title.contains(keyword)) {
                System.out.println(postsArray[i]);
                anyPostFound = true;
            }
        }
        if (!anyPostFound) {
            throw new PostNotFoundException("there is not post with given keyword");
        }
    }

    /*
     տպում է բոլոր գրառումները
     */
    public void printAllPosts() throws PostNotFoundException {
        if (isEmpty()) {
            throw new PostNotFoundException("you are trying to find post in empty storage");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(postsArray[i]);
            }
        }

    }

    /*
    տպում է գրառումները ըստ կատեգորիայի
     */
    public void printPostsByCategory(Category category) throws PostNotFoundException {
        if (isEmpty()) {
            throw new PostNotFoundException("you are trying to find post in empty storage");
        }

        boolean anyCategoryFound = false;
        for (int i = 0; i < size; i++) {
            if (postsArray[i].getCategory() == category) {
                System.out.println(postsArray[i]);
                anyCategoryFound = true;
            }
        }
        if (!anyCategoryFound) throw new PostNotFoundException("post not found");
    }


    private void extend() {
        Post[] tmp = new Post[(int) (postsArray.length * 1.7)];
        System.arraycopy(postsArray, 0, tmp, 0, postsArray.length);
        postsArray = tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "PostStorageInit{" +
                "posts=" + Arrays.toString(postsArray) +
                ", size=" + size +
                '}';
    }
}
