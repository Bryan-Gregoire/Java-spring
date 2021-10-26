package com.example.demo.model;

import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class Course {

    @Size(min = 3, max = 6, message = "Entrer une chaine entre 3 et 6 lettres et/ou chiffres")
    private final String id;

    @Size(min = 3, max = 50, message = "Entrer une chaine entre 3 et 50 lettres et/ou chiffres")
    private final String libelle;

    @Min(value = 1, message = "Le nombre ne peut pas être inférieur à 1")
    @Max(value = 60, message = "Le nombre ne peut pas être supérieur à 60")
    private final int ects;
}
