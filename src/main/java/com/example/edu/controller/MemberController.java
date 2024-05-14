package com.example.edu.controller;

import com.example.edu.model.Member;
import com.example.edu.model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {


    @GetMapping("/members")
    public ResponseEntity<Member> getMember(){
        Member member = new Member("신건영", 100, Role.ADMIN);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/name")
    public String getName(){
        return "신건영";
    }

}
