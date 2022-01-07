package com.example.demo.web;

import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDB;

import org.springframework.validation.Errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentCtrl {

    @Autowired
    private StudentDB studentDB;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentDB.findAll());
        model.addAttribute("student", new Student());
        return "students";
    }

    @PostMapping("/students")
    public String students(@Valid Student student, Errors errors, Model model) {
        if (errors.hasErrors()) {} else {
            studentDB.save(student);
            model.addAttribute("student", new Student());
        }
        model.addAttribute("students", studentDB.findAll());
        return "students";
    }

    @GetMapping("/student/courses")
    public String studentsCourses(@RequestParam int studentId, Model model) {
        Optional<Student> studOptional = studentDB.findById(studentId);
        Student student = studOptional.get();

        model.addAttribute("student", student);
        model.addAttribute("courses", student.getMyCourses());
        
        return "studentCourses";
    }
}
