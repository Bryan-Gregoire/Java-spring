package com.example.demo.repository_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.model.Gender;
import com.example.demo.model.Section;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest()
public class StudentRepositoryTest {

    @Autowired
    private StudentDB studentRepository;

    @BeforeEach
    public void init() {
        studentRepository.deleteAll();
    }

    @Test
    public void findByNameContainingOne() {
        Student student = new Student(1234, "azertyuiop", Gender.MALE, Section.GESTION);
        Student student2 = new Student(4321, "qsdfghjklm", Gender.MALE, Section.GESTION);

        studentRepository.save(student);
        studentRepository.save(student2);

        List<Student> found = studentRepository.findByNameContaining("t");

        assertEquals(1, found.size());
        assertEquals(student, found.get(0));
    }

    @Test
    public void findByNameContainingMany() {
        Student student = new Student(1234, "azertyuiop", Gender.MALE, Section.GESTION);
        Student student2 = new Student(4321, "poiuytreza", Gender.MALE, Section.GESTION);
        Student student3 = new Student(2134, "yturieozpa", Gender.MALE, Section.GESTION);

        studentRepository.save(student);
        studentRepository.save(student2);
        studentRepository.save(student3);

        List<Student> found = studentRepository.findByNameContaining("t");

        assertEquals(3, found.size());
        assertEquals(student, found.get(0));
        assertEquals(student2, found.get(1));
        assertEquals(student3, found.get(2));
    }

    @Test
    public void findByNameContainingNoOne() {
        Student student = new Student(1234, "azerty", Gender.MALE, Section.GESTION);
        Student student2 = new Student(4321, "ytreza", Gender.MALE, Section.GESTION);
        Student student3 = new Student(2134, "testName", Gender.MALE, Section.GESTION);

        studentRepository.save(student);
        studentRepository.save(student2);
        studentRepository.save(student3);

        List<Student> found = studentRepository.findByNameContaining("x");

        assertEquals(0, found.size());
    }
}
