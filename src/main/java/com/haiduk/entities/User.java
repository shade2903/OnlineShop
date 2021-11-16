package com.haiduk.entities;

public class User {
    private static User instance = new User();
    private String name;

    public static User getInstance(){
        return instance;
    }

    public void add(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
