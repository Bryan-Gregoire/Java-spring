package com.example.demo.model;

import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@Value
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @Size(min = 3, max = 6, message = "Entrer une chaine entre 3 et 6 lettres et/ou chiffres")
    private String id;

    @Size(min = 3, max = 50, message = "Entrer une chaine entre 3 et 50 lettres et/ou chiffres")
    private String libelle;

    @Min(value = 1, message = "Le nombre ne peut pas être inférieur à 1")
    @Max(value = 60, message = "Le nombre ne peut pas être supérieur à 60")
    private int ects;
}
