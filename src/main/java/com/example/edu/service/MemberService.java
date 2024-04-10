package com.example.edu.service;

import com.example.edu.model.Member;
import com.example.edu.model.MemberLoginRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public Member login(MemberLoginRequest loginRequest) {

        return new Member();
    }
}
