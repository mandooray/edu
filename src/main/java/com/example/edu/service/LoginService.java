package com.example.edu.service;

import com.example.edu.controller.Auth;
import com.example.edu.controller.MemberLoginRequest;
import com.example.edu.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private MemberService memberService;
    public Member login(MemberLoginRequest memberLoginRequest){
        return memberService.getMember(memberLoginRequest.getId());
    }

}
