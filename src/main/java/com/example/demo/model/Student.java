package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Student {

    
    @Id
    @GeneratedValue(generator = "seq")
    @SequenceGenerator(name="seq", initialValue=3)
    private int id;

    @Min(value = 1, message = "Le nombre ne peut pas être inférieur à 1")
    @Max(value = 100000, message = "Le nombre ne peut pas être supérieur à 20000")
    @Column(unique = true)
    private int matricule;

    @Size(min = 3, message = "Entrer une chaine d'au moins 3 caractères")
    private String name;

    @Enumerated(EnumType.STRING) // Option pour map la valeur de l'enum en String dans la DB car c'est un INT par défaut
    @NotNull(message = "Veuillez précisez votre sex")
    private Gender gender;

    @Enumerated(EnumType.STRING) // Option pour map la valeur de l'enum en String dans la DB car c'est un INT par défaut
    @NotNull(message = "Veuillez précisez votre section")
    private Section section;

    @ManyToMany
    @JoinTable(  // Pas obligatoire, permet de configurer le nom de la table et celles des colonne
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> myCourses;

}
