package com.example.edu.service;

import com.example.edu.model.Member;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

public class CustomUserDetailsService implements UserDetailsService {
    private PasswordEncoder passwordEncoder;
    private MemberService memberService;
    public CustomUserDetailsService(PasswordEncoder passwordEncoder, MemberService memberService) {
        this.passwordEncoder = passwordEncoder;
        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.getMember(username);
        if (member == null) {
            throw new UsernameNotFoundException("not found");
        }

        return new User(member.getId(), passwordEncoder.encode(member.getPassword()), Arrays.asList(new SimpleGrantedAuthority(member.getRole().toString())));
    }
}
