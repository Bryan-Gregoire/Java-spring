package com.example.demo.web;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDB;
import com.example.demo.model.StudentDB;

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
    private CourseDB courseDB;

    @Autowired
    private StudentDB studentDB;

    @GetMapping("/coursesjson")
    public String getCoursesJson() {
        Iterable<Course> courses = courseDB.findAll();
        String coursesStr = "";
        for (Course cours : courses) {
            coursesStr += " ID : " + cours.getId() + ", Libelle : " + cours.getLibelle() + ", ECTS : " + cours.getEcts()
                    + "<br>";
        }
        return coursesStr;
    }

    @GetMapping("/courses/student")
    public String getStudentCoursesJSON() {
        RestTemplate restTemplate = new RestTemplate();
        String coursesString = restTemplate.getForObject("https://intense-stream-63269.herokuapp.com/api/coursesjson",
                String.class);
        System.out.println(coursesString);
        return coursesString;
    }

    // Test Chapitre 17

    @GetMapping("/coursesEctsjson")
    public String getEctsJson() {
        Iterable<Course> courses = courseDB.findByEctsGreaterThanEqual(5);
        String coursesStr = "";
        for (Course cours : courses) {
            coursesStr += " ID : " + cours.getId() + ", Libelle : " + cours.getLibelle() + ", ECTS : " + cours.getEcts()
                    + "<br>";
        }
        return coursesStr;
    }

    @GetMapping("/coursesLibellejson")
    public String getLibelleJson() {
        Iterable<Course> courses = courseDB.findByLibelleContaining("loppe");
        String coursesStr = "";
        for (Course cours : courses) {
            coursesStr += " ID : " + cours.getId() + ", Libelle : " + cours.getLibelle() + ", ECTS : " + cours.getEcts()
                    + "<br>";
        }
        return coursesStr;
    }

    @GetMapping("/studentsName")
    public String getStudentNameJson() {
        Iterable<String> listNames = studentDB.findAllStudentName();
        String nameStr = "";
        for (String student : listNames) {
            nameStr += " Name : " + student + "<br>";
        }
        return nameStr;
    }

    @GetMapping("/studentsIdAndName")
    public String getStudentIdAndNameJson() {
        Iterable<Object[]> listNames = studentDB.findAllStudentIdAndNameStudents();
        String objectStr = "";
        for (Object[] student : listNames) {
            objectStr += " ID : " + student[0] + " NAME : " + student[1] + "<br>";
        }
        return objectStr;
    }

    @GetMapping("/studentsNameAndEctsTotal")
    public String getStudentNameAndEctsTotalJson() {
        Iterable<Object[]> listStud = studentDB.findAllStudentNameAndTotalEcts();
        String objectStr = "";
        for (Object[] student : listStud) {
            objectStr += " NAME : " + student[0] + " --->  ECTS : " + student[1] + "<br>";
        }
        return objectStr;
    }

    @GetMapping("/studentsEctsBiggerThan")
    public String getStudentsEctsBiggerThanJson() {
        Iterable<Object[]> listStud = studentDB.findAllStudentEctsGreaterThan(13);
        String objectStr = "";
        for (Object[] student : listStud) {
            objectStr += " NAME : " + student[0] + " --->  ECTS : " + student[1] + "<br>";
        }
        return objectStr;
    }

}
