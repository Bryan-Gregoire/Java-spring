package com.example.demo.web;

import java.util.ArrayList;

import com.example.demo.business.PAE;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseCtrl {

    @GetMapping("/courses")
    public String courses(Model model) {
        PAE pae = new PAE();
        model.addAttribute("courses", pae.getCourses());
        return "courses";
    }
}
