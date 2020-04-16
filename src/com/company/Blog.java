package com.company;

import java.util.Scanner;

public class Blog implements Commands {

    static PostStorage storage = new PostStorage();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        main:
        while (true) {
            printCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("You have to enter a number between 0 to 4");
                continue;
            }

            switch (command) {

                case EXIT:
                    break main;

                case ADD_POST:
                    System.out.print("please enter 3  values for the new post you want to add\nand divide them by ','");
                    addPost();
                    break;
                case SEARCH_POST:
                    System.out.print("Enter Keyword For Finding Posts");
                    search(scanner.next());
                    break;
                case POSTS_BY_CATEGORY:
                    System.out.println("Enter Category");
                    postsByCategory(scanner.next());
                    break;
                case ALL_POSTS:
                    storage.printAllPosts();
                    break;
                default:
                    System.out.println("There is not such command \nPlease enter the write command");
            }
        }

        System.out.print("its done");

    }

    private static void printCommands() {
        System.out.println("please input " + EXIT + " for exit ");
        System.out.println("please input " + ADD_POST + " for adding post");
        System.out.println("please input " + SEARCH_POST + " for searching post");
        System.out.println("please input " + POSTS_BY_CATEGORY + " for searching post by category");
        System.out.println("please input " + ALL_POSTS + " for searching all posts");
    }

    private static void postsByCategory(String category) {
        try {
            storage.printPostsByCategory(category);
        } catch (PostNotFoundException e) {
            System.out.println("there is not post with that category");
        }
    }

    private static void addPost() {
        String[] values = scanner.next().split(",");
        if (values.length != 3) {
            System.out.println("fail\nthe values have to be 3");
            return;
        }
        storage.add(new Post(values[0], values[1], values[2]));
    }

    static void search(String keyword) {
        try {
            storage.searchPostsByKeyword(keyword);
        } catch (PostNotFoundException e) {
            // e.printStackTrace();
            System.out.println("no posts found with given keyword");
        }

    }
}
