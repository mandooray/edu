package com.example.edu.model;

import lombok.Getter;

@Getter
public class Requester {
    String ip;

    public Requester(String ip) {
        this.ip = ip;
    }
}
