package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.business.PAE;

@Controller
public class CourseCtrl {

    @GetMapping("/courses")
    public String courses(Model model) {
        PAE pae = new PAE(); // Possible de faire sans "new" grace a @service de la classe ?
        model.addAttribute("courses", pae.getCourses());
        return "courses";
    }

    @GetMapping("/courses/detail")
    public String courseDetail(@RequestParam String coursId, Model model) {
        model.addAttribute("cours", coursId);
        return "detail";
    }

}
