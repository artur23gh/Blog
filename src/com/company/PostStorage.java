package com.company;

import java.util.Arrays;

class PostStorage {

    private Post[] postsArray = new Post[10];
    int size = 0;

    void add(Post post) {
        if (size == postsArray.length) {
            extend();
        }
        postsArray[size++] = post;

        // temporary operation
        System.out.println("the new post is added with this parameters "
                + " title = " + postsArray[size - 1].getTitle()
                + " , text = " + postsArray[size - 1].getText()
                + " , cotegory = " + postsArray[size - 1].getCategory()
                + " , createDate = " + postsArray[size - 1].getCreateDate()
        );

    }

    /*
    վերադարձնում ենք Գրառումը ըստ տրված վերնագրի
     */
    Post getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < size; i++) {
            if (title.equals(postsArray[i].getTitle())) {
                return postsArray[i];
            }
        }
        throw new PostNotFoundException();
    }

    /*
    տպում է գրառումը եթե տրված keyword բառը պարունակում է կամ վերնագրի մեջ,
     կամ տեքստ-ի։(String-ը ունի contains մեթոդը, իրանով երեք)
     */
    void searchPostsByKeyword(String keyword) throws PostNotFoundException {
        System.out.println("method  for keyword");

        boolean anyPostFound = false;

        for (int i = 0; i < size; i++) {
            String title = postsArray[i].getTitle();
            String text = postsArray[i].getText();
            if (text.contains(keyword) || title.contains(keyword)) {
                System.out.println(postsArray[i].toString());
                anyPostFound = true;
            }
        }
        if (!anyPostFound) {
            throw new PostNotFoundException();
        }
    }

    /*
     տպում է բոլոր գրառումները
     */
    void printAllPosts() {
        if (size > 0) {
            /*
            // this  for each  does not work why ?
             for (Post post: postsArray) {
                    System.out.println(post);
                }
             */


            for (int i = 0; i < size; i++) {
                System.out.println(postsArray[i]);
            }
        } else System.out.println("Storage is empty");

    }

    /*
    տպում է գրառումները ըստ կատեգորիայի
     */
    void printPostsByCategory(String category) throws PostNotFoundException {
        boolean anyCategoryFound = false;
        for (int i = 0; i < size; i++) {
            if (postsArray[i].getCategory().equals(category)) {
                System.out.println(postsArray[i]);
                anyCategoryFound = true;
            }
        }
        if (!anyCategoryFound) throw new PostNotFoundException();
    }


    private void extend() {
        int length = postsArray.length;
        int newLength = (int) (length * 1.7);

        Post[] tmp = new Post[newLength];
        for (int i = 0; i < length; i++) {
            tmp[i] = postsArray[i];
        }
        postsArray = tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "PostStorage{" +
                "posts=" + Arrays.toString(postsArray) +
                ", size=" + size +
                '}';
    }
}

