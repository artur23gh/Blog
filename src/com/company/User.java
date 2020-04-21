package com.company;

public class User {
    public User(String name, String surName, String email, Gender gender, String password) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    String name;
    String surName;
    String email;
    Gender gender;
    String password;

}
