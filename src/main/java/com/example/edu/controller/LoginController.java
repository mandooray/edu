package com.example.edu.controller;

import com.example.edu.model.Member;
import com.example.edu.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String loginPage() {
        return "login";
    }
    @PostMapping
    public ModelAndView processLogin(MemberLoginRequest loginRequest)  {
        Member memberResponse = loginService.login(loginRequest);
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("loginName", memberResponse.getName());
        return mav;
    }
}
