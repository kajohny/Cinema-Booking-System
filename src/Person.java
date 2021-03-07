package com.company;

public class Person {
    private String name;
    private String email;
    private int age;

    public Person() {}

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
