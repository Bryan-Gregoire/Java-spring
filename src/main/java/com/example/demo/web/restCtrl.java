package com.example.demo.web;

import java.util.List;

import com.example.demo.business.PAE;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/courses/student")
    public void getStudentCoursesJSON() {
        RestTemplate restTemplate = new RestTemplate(); // Course info =
        String coursesString = restTemplate.getForObject("https://intense-stream-63269.herokuapp.com/api/coursesjson",
                String.class);
        System.out.println(coursesString);
    }

}
