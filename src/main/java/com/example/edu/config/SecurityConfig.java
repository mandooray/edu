package com.example.edu.config;

import com.example.edu.service.CustomUserDetailsService;
import com.example.edu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    MemberService memberService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(Customizer.withDefaults());


        http.authorizeHttpRequests(authorizeRequests ->
                                           authorizeRequests
                                                   .requestMatchers("/members").permitAll()
                                                   .requestMatchers("/admin/**").hasRole("ADMIN")
                                                   .requestMatchers("/private-project/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MEMBER")
                                                   .requestMatchers("/public-project/**").authenticated()
                                                   .anyRequest().authenticated()
                                  );

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                                .username("admin")
//                                .password("admin")
//                                .roles("ADMIN")
//                                .build();
//
//        UserDetails member = User.withDefaultPasswordEncoder()
//                                .username("member")
//                                .password("member")
//                                .roles("MEMBER")
//                                .build();
//        return new InMemoryUserDetailsManager(admin, member);
//    }

    @Bean
    public CustomUserDetailsService userDetailsService2(PasswordEncoder passwordEncoder) {
        return new CustomUserDetailsService(passwordEncoder, memberService);
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
