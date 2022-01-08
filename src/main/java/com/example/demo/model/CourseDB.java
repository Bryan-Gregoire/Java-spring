package com.example.demo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseDB extends CrudRepository<Course, String> {

    // TEST CHAPITRE 17 

    List<Course> findByEctsGreaterThanEqual(int nb);

    List<Course> findByLibelleContaining(String libelle);

    // FIN TEST
}
