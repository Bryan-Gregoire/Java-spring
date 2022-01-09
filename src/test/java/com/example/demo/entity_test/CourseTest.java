package com.example.demo.entity_test;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.example.demo.model.Course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseTest {

    @Autowired
    private BeanValidationUtil<Course> validator;

    @Test
    public void idValid() {
        Course course = new Course("ValId", "libelle", 1);
        validator.assertIsValid(course);
    }

    @Test
    public void idSizeLessThan3Error() {
        Course course = new Course("id", "libelle", 1);
        validator.assertHasError(course, "id", Size.class);
    }

    @Test
    public void idSizeGreaterThan6Error() {
        Course course = new Course("notValid", "libelle", 1);
        validator.assertHasError(course, "id", Size.class);
    }

    @Test
    public void libelleValid() {
        Course course = new Course("ValId", "ValidLibelle", 1);
        validator.assertIsValid(course);
    }

    @Test
    public void libelleSizeLessThan3Error() {
        Course course = new Course("valId", "li", 1);
        validator.assertHasError(course, "libelle", Size.class);
    }

    @Test
    public void libelleSizeGreaterThan50Error() {
        Course course = new Course("valId", "azertyuiopqsdfghjklmwxcvbnnbvcxwmlkjhgfdsqpoiuytreza", 1);
        validator.assertHasError(course, "libelle", Size.class);
    }

    @Test
    public void ectsValid() {
        Course course = new Course("ValId", "libelle", 60);
        validator.assertIsValid(course);
    }

    @Test
    public void ectsMinLessThan1Error() {
        Course course = new Course("valId", "libelle", 0);
        validator.assertHasError(course, "ects", Min.class);
    }

    @Test
    public void ectsMaxGreaterThan60Error() {
        Course course = new Course("valId", "libelle", 61);
        validator.assertHasError(course, "ects", Max.class);
    }
}
