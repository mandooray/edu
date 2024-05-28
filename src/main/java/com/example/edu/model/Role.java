package com.example.edu.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    ADMIN, MEMBER, GUEST;


    @JsonCreator
    static public Role fromString(String str){
        for (Role value : values()) {
            if (value.name().toLowerCase().equalsIgnoreCase(str)) {
                return value;
            }
        }
        return GUEST; //default
    }



    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
