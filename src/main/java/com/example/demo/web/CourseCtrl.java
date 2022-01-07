package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.validation.Errors;

import lombok.extern.slf4j.Slf4j;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDB;

@Controller
@Slf4j
public class CourseCtrl {

    @Autowired
    private CourseDB courseDB;

    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", courseDB.findAll());
        model.addAttribute("course", new Course(null, null, 0));
        return "courses";
    }

    @GetMapping("/courses/detail")
    public String courseDetail(@RequestParam String coursId, Model model) {
        Optional<Course> courseResOptional = courseDB.findById(coursId);
        Course course = courseResOptional.get();

        model.addAttribute("course", course);
        model.addAttribute("students", course.getStudents());
        return "detail";
    }

    @PostMapping("/courses")
    public String addCourse(@Valid Course cours, Errors errors, Model model) {
        if (errors.hasErrors()) {
            log.info("Il y a des erreurs mon petit lapin");
        } else {
            courseDB.save(new Course(cours.getId(), cours.getLibelle(), cours.getEcts()));
            log.info("Cours ajouter :" + cours);
            log.info("Tous les cours dans la BD : " + courseDB.findAll());
        }

        model.addAttribute("courses", courseDB.findAll());
        return "courses";
    }

}
