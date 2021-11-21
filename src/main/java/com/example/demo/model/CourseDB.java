package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;


public interface CourseDB extends CrudRepository<Course, String> {
    
}
