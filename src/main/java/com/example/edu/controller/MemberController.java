package com.example.edu.controller;

import com.example.edu.MessageSendService;
import com.example.edu.model.Member;
import com.example.edu.model.Requester;
import com.example.edu.model.Role;
import com.example.edu.model.SendRequset;
import com.example.edu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MessageSendService messageSendService;

    @Autowired
    private MemberService memberService;


    @GetMapping("/name")
    public String getName(){

        return "신건영";
    }

    @PostMapping("/send")
    public String getMember(@RequestBody SendRequset sendRequset){
        messageSendService.send(sendRequset.getText(), sendRequset.getName());
        return "success";
    }

    @GetMapping("/me")
    public Member getMember(@Auth Requester requester, Pageable pageable){

        return new Member("신건영", 10, Role.MEMBER);
    }



    @PostMapping("/members")
    public Member getMember(@RequestBody Member member){
        return memberService.saveUser(member);
    }

    @GetMapping("/members")
    public List<Member> getMember(){
        return memberService.getList();
    }

    @GetMapping("/members/{memberId}")
    public Member getMember(@PathVariable String memberId){
        return memberService.getMember(memberId);
    }
//
//    @PutMapping("/members/{memberId}")
//    public Member getMember(@RequestBody Member member, @PathVariable String memberId){
//        return memberService.updateMember(memberId, member);
//    }



}
