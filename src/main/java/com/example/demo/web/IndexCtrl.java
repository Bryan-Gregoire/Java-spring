package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtrl {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
