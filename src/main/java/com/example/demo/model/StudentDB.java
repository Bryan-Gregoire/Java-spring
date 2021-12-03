package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface StudentDB extends CrudRepository<Student, Integer> {
}
