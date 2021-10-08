package com.example.demo.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Course;

import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class PAE {

    public List<Course> getCourses() {
        return Arrays.asList(new Course("INT", "Introduction", 10), new Course("MAT1", "Mathematics 2", 3),
                new Course("CAI1", "Anglais", 2), new Course("DEV1", "Developpement 1", 10),
                new Course("DEV2", "Developpement 2", 10), new Course("WEBG2", "Developpement web 1", 5));
    }
}
