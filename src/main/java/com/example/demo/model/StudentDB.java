package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentDB extends CrudRepository<Student, Integer> {

    // TEST Chapitre 17
    
    @Query("SELECT s.name FROM Student s")
    List<String> findAllStudentName();

    @Query("SELECT s.id, s.name FROM Student s")
    List<Object[]> findAllStudentIdAndNameStudents();

    @Query("SELECT s.name, SUM(c.ects) FROM Student s JOIN s.myCourses c GROUP BY s.id")
    List<Object[]> findAllStudentNameAndTotalEcts();

    @Query("SELECT s.name, SUM(c.ects) FROM Student s JOIN s.myCourses c GROUP BY s.id HAVING SUM(c.ects) > :nbEcts ")
    List<Object[]> findAllStudentEctsGreaterThan(long nbEcts);

    // FIN TEST

    List<Student> findByNameContaining(String name);
}
