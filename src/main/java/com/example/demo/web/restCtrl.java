package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.business.PAE;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class restCtrl {

    @Autowired
    private PAE pae;

    @GetMapping("/coursesjson")
    public String getCoursesJson() {
        List<Course> courses = pae.getCourses();
        String coursesStr = "";
        for (Course cours : courses) {
            coursesStr += " ID : " + cours.getId() + ", Libelle : " + cours.getLibelle() + ", ECTS : " + cours.getEcts()
                    + "<br>";
        }
        return coursesStr;
    }

}
