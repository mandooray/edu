package com.example.edu.model;

import lombok.Getter;

@Getter
public class Member {
    private String name;
    private int age;
    private Role role;

    public Member(String name, int age, Role role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }
}
