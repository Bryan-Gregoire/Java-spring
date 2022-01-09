package com.example.demo.entity_test;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.example.demo.model.Gender;
import com.example.demo.model.Section;
import com.example.demo.model.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
    
    @Autowired
    private BeanValidationUtil<Student> validator;

    @Test
    public void matriculeValid() {
        Student student = new Student(100000, "name", Gender.MALE, Section.GESTION);
        validator.assertIsValid(student);
    }

    @Test
    public void matriculeLessThan1Error() {
        Student student = new Student(0, "name", Gender.MALE, Section.GESTION);
        validator.assertHasError(student, "matricule", Min.class);
    }

    @Test
    public void matriculeGreaterThan100000Error() {
        Student student = new Student(100001, "name", Gender.MALE, Section.GESTION);
        validator.assertHasError(student, "matricule", Max.class);
    }

    @Test
    public void nameValid() {
        Student student = new Student(12345, "nameValid", Gender.MALE, Section.GESTION);
        validator.assertIsValid(student);
    }

    @Test
    public void nameSizeLessThan3Error() {
        Student student = new Student(12345, "lu", Gender.MALE, Section.GESTION);
        validator.assertHasError(student, "name", Size.class);
    }
}
