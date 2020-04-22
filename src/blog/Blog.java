package blog;

import blog.exception.PostNotFoundException;
import blog.model.Post;
import blog.storage.PostStorage;
import blog.storage.PostStorageImpl;
import blog.storage.UserStorage;
import blog.storage.UserStorageImpl;

import java.util.Scanner;

public class Blog implements Commands {

    private static final PostStorageImpl POST_STORAGE = new PostStorageImpl();
    private static final UserStorageImpl USER_STORAGE = new UserStorageImpl();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isRegisteredUser = false;

        main:
        while (true) {

            printCommands(isRegisteredUser);
            int command;
            try {
                command = Integer.parseInt(SCANNER.next());
            } catch (NumberFormatException e) {
                System.out.println(" You have to enter a digit ");
                continue;
            }

            switch (command) {

                case EXIT:
                    break main;

                case ADD_POST:
                    if (!isRegisteredUser) {
                        System.out.println("you have to lig in first for being able to add post ");
                    } else {
                        addPost();
                    }
                    break;

                case SEARCH_POST:
                    System.out.print("Enter Keyword For Finding Posts");
                    search(SCANNER.next());
                    break;
                case POSTS_BY_CATEGORY:
                    postsByCategory(SCANNER.next());
                    break;
                case ALL_POSTS:
                    printAllPosts();
                    break;


                
                case REGISTER:
                    register();
                    break;
                    
                case DELETE_PROFILE:
                    deleteProfilr();
                    break ;
                    
                 case LOG_IN:
                    logIn();
                    break;
                    
                case LOG_OUT:
                    logOut();
                    break;
                    
                case EDIT_PROFILE:
                    editProfile();
                    break;

                default:
                    System.out.println("Invalid command \nPlease enter the write command");
            }
        }

        System.out.print("its done");

    }

    private static void logIn() {
        System.out.println("enter your email");
        String givenEmail = scanner.next();
        if (!givenEmail.endsWith("@mail.ru")) {
            givenEmail += "@mail.ru";
        }
        if (userStorage.hasUserWithEmail(givenEmail)) {
            System.out.println("please enter another email");
        } else {
            System.out.println("good" + "\n" + "now enter your password ");
            String givenPassword = scanner.next();
            if (hasUserWithPassword(givenPassword)) {
                System.out.println("please enter another password");
            } else {
                System.out.println("congratulations now you are a user");

                a1:
                while (true) {
                    System.out.println("if you want to edit your profile now enter 1 either enter 0");
                    int data = 0;
                    try {
                        data = Integer.parseInt(scanner.next());
                    } catch (NumberFormatException e) {
                        System.out.println("you have to enter digit ( 1 or 0)");
                    }
                    switch (data) {
                        case 0:
                            userStorage.add(new User(givenEmail, givenPassword));

                            break a1;
                        case 1:
                            userStorage.editProfile();

                            break a1;
                        default:
                            System.out.println("you did wrong choise");

                            break;
                    }
                }


            }
        }
    }


    private static void postsByCategory(String category) {
        System.out.println("Enter Category");

        try {
            POST_STORAGE.printPostsByCategory(Category.valueOf(category.toUpperCase()));
        } catch (PostNotFoundException e) {
            System.out.println(e);
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("there is not post category like"
                    + " \" " + category + " \" " + "\n"
                    + "the categories are \"Special\" , \"Ordinary\" and \"Additional\" ");

            return;
        }
    }

    private static void addPost() {
        System.out.print("please enter title , text , category and divide them by ','");

        String[] postData = SCANNER.next().split(",");

        if (postData.length != 3) {
            System.out.println("fail\nthe values have to be 3(text,data and category)");
            return;
        }

        try {
            POST_STORAGE.add(new Post(postData[0], postData[1], Category.valueOf(postData[2].toUpperCase())));
        } catch (IllegalArgumentException e) {
            System.out.println("there is not post category like"
                    + " \" " + postData[2] + " \" " + "the categories are \"Special\" , \"Ordinary\" and \"Additional\" ");
            return;
        }
    }

    static void search(String keyword) {
        try {
            POST_STORAGE.searchPostsByKeyword(keyword);
        } catch (PostNotFoundException e) {
            System.out.println(e + " \n " + "no post found with given keyword");
        }

    }

    static void printAllPosts() {
        try {
            POST_STORAGE.printAllPosts();
        } catch (PostNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void printCommands(boolean isRegisteredUser) {

        if (isRegisteredUser) {
            printCommandsForRegisteredUser();
        } else {
            printCommandsForNotRegisteredUser();
        }

    }

    private static void printCommandsForRegisteredUser() {

        System.out.println("please enter" + EXIT + "for exit");
        System.out.println("enter" + ADD_POST + "for adding post");
        System.out.println("enter" + SEARCH_POST + "for searching post");
        System.out.println("enter" + POSTS_BY_CATEGORY + "for searching post by category");
        System.out.println("enter" + ALL_POSTS + "for searching all posts");
        //System.out.println("enter" + REGISTER + "for register");
        System.out.println("enter" + DELETE_PROFILE + "for deleting profile");
        //System.out.println("enter" + LOG_IN + "for log in");
        System.out.println("enter" + LOG_OUT + "for logging out");
        System.out.println("enter" + EDIT_PROFILE + "for editing your profile");

    }

    private static void printCommandsForNotRegisteredUser() {

        System.out.println("please enter" + EXIT + "for exit");
        //System.out.println("enter" + ADD_POST + "for adding post");
        System.out.println("enter" + SEARCH_POST + "for searching post");
        System.out.println("enter" + POSTS_BY_CATEGORY + "for searching post by category");
        System.out.println("enter" + ALL_POSTS + "for searching all posts");
        System.out.println("enter" + REGISTER + "for register");
        //System.out.println("enter" + DELETE_PROFILE + "for deleting profile");
        System.out.println("enter" + LOG_IN + "for log in");
        //System.out.println("enter" + LOG_OUT + "for logging out");
        //System.out.println("enter" + EDIT_PROFILE + "for editing your profile");
    }
}
