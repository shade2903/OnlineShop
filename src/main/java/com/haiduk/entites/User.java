package com.haiduk.entites;

public class User {
    private String name;
    public String user = "Tolay";
    public User(){

    }
    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
