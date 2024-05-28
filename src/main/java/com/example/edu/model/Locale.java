package com.example.edu.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Locale {
    KO("ko"), EN("en"), JP("jp"), MEMBER_CREATE("memberCreate");
    String val;
    Locale(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "string";
    }
}

