package com.example.demo.business;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.demo.model.Course;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Bean
public class PAE {

    public ArrayList<Course> getCourses() {
        Course cours1 = new Course("INT", "Introduction", 10);
        Course cours2 = new Course("MAT1", "Mathematics 2", 3);
        Course cours3 = new Course("CAI1", "Anglais", 2);
        Course cours4 = new Course("DEV1", "Developpement 1", 10);
        Course cours5 = new Course("DEV2", "Developpement 2", 10);
        Course cours6 = new Course("WEBG2", "Developpement web 1", 5);
        ArrayList<Course> cours = new ArrayList<>(Arrays.asList(cours1, cours2, cours3, cours4, cours5, cours6));
        return cours;
    }
}
