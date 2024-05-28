package com.example.edu.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private String id;
    private String name;
    private String password;
    private Integer age;
    @JsonSerialize(using = ToStringSerializer.class)
    private Role role;


    public Member(String name, int age, Role role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }
}
