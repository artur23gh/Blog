package com.company;

public  class PostNotFoundException extends Exception {
    @Override
    public String toString() {
        return " no any post found ";
    }
}
