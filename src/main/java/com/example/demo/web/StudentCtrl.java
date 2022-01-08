package com.example.demo.web;

import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDB;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDB;

import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentCtrl {

    @Autowired
    private StudentDB studentDB;

    @Autowired
    private CourseDB courseDB;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentDB.findAll());
        model.addAttribute("student", new Student());
        return "students";
    }

    @GetMapping("/student/courses")
    public String studentsCourses(@RequestParam int studentId, Model model) {
        Optional<Student> studOptional = studentDB.findById(studentId);
        Student student = studOptional.get();

        model.addAttribute("student", student);
        model.addAttribute("courses", student.getMyCourses());
        model.addAttribute("courseNotEnrolled", courseDB.findAll());

        return "studentCourses";
    }

    @PostMapping("/students")
    public String students(@Valid Student student, Errors errors, Model model) {
        if (errors.hasErrors()) {
        } else {
            try {
                studentDB.save(student);
            } catch (DataIntegrityViolationException e) {
                model.addAttribute("etudiantExisteMessage", "Cet matricule existe déja !");
            }
            model.addAttribute("student", new Student());
        }
        model.addAttribute("students", studentDB.findAll());
        return "students";
    }

    @PostMapping("/student/course/registration")
    public String registerStudentToCourse(@RequestParam int studentId, @RequestParam String courseId, Model model) {
        Student student = studentDB.findById(studentId).get();
        Course course = courseDB.findById(courseId).get();

        student.getMyCourses().add(course);
        course.getStudents().add(student);

        studentDB.save(student);
        courseDB.save(course);

        return "redirect:/student/courses/?studentId=" + studentId;
    }

    @PostMapping("/students/search")
    public String searchStudents(@RequestParam String studentName, Model model) {
        model.addAttribute("students", studentDB.findByNameContaining(studentName));
        model.addAttribute("student", new Student());
        return "students";
    }

}
