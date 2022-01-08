package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.collections.List;
import lombok.extern.slf4j.Slf4j;

import java.lang.ProcessBuilder.Redirect;

import javax.validation.Valid;
import org.springframework.validation.Errors;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDB;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDB;

@Controller
@Slf4j
public class CourseCtrl {

    @Autowired
    private CourseDB courseDB;

    @Autowired
    private StudentDB studentDB;

    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", courseDB.findAll());
        model.addAttribute("course", new Course(null, null, 0));
        return "courses";
    }

    @GetMapping("/courses/detail")
    public String courseDetail(@RequestParam String coursId, Model model) {
        Course course = courseDB.findById(coursId).get();

        model.addAttribute("course", course);
        model.addAttribute("students", course.getStudents());
        model.addAttribute("studentsNotRegister", studentDB.findAll());
        return "detail";
    }

    @PostMapping("/courses")
    public String addCourse(@Valid Course cours, Errors errors, Model model) {
        if (!errors.hasErrors()) {
            courseDB.save(new Course(cours.getId(), cours.getLibelle(), cours.getEcts()));
        }
         
        model.addAttribute("courses", courseDB.findAll());
        return "courses";
    }

    @PostMapping("/course/student/registration")
    public String registerStudentToCourse(@RequestParam int studentId, @RequestParam String courseId,  Model model) {    
        Course course = courseDB.findById(courseId).get();
        Student student = studentDB.findById(studentId).get();
        
        course.getStudents().add(student);
        student.getMyCourses().add(course);

        courseDB.save(course);
        studentDB.save(student);

        return "redirect:/courses/detail?coursId="+courseId;
    }

}
