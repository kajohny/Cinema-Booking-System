package com.company;

public class User extends Person { //creating child class
    private int userId;

    public User(String name, String email, int age, int userId) {
        super(name, email, age);
        this.userId = userId;
    }

    public User(int userId, String name, String email) {
        super(name, email);
        this.userId = userId;
    }

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
