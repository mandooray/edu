package com.example.edu.controller;

import com.example.edu.model.Member;
import com.example.edu.model.MemberLoginRequest;
import com.example.edu.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    // TODO #6: 로그인 폼
    @GetMapping
    public String loginPage() {
        return "login";
    }

    // TODO #7: 실습 - 로그인 처리
    @PostMapping
    public ModelAndView processLogin(MemberLoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response)  {
        Member memberResponse = memberService.login(loginRequest);
        HttpSession session = request.getSession();
        session.setAttribute("loginId", memberResponse.getId());
        Cookie cookie = new Cookie("SESSION", session.getId());
        response.addCookie(cookie);
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("loginName", memberResponse.getName());
        return mav;
    }


}
