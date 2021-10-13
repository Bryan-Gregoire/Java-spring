package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

import com.example.demo.business.PAE;
import com.example.demo.model.Course;

@Controller
@Slf4j
public class CourseCtrl {

    @Autowired
    PAE pae;

    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", pae.getCourses());
        model.addAttribute("course", new Course(null, null, 0));
        return "courses";
    }

    @GetMapping("/courses/detail")
    public String courseDetail(@RequestParam String coursId, Model model) {
        model.addAttribute("cours", coursId);
        return "detail";
    }

    @PostMapping("/courses")
    public String addCourse(Course cours, Model model) {
        log.info("Cours ajouter : id : " + cours.getId() + ", libelle : " + cours.getLibelle() + ", ects : "
                + cours.getEcts());
        model.addAttribute("courses", pae.getCourses());
        return "courses";
    }

}
