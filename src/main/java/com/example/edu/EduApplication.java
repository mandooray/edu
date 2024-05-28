package com.example.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EduApplication {

    public static void main(String[] args) {
        System.out.println();
        SpringApplication.run(EduApplication.class, args);
        System.out.println();
    }

}
