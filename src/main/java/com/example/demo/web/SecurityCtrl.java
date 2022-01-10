package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityCtrl {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
