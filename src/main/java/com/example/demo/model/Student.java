package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue
    private int matricule;

    @Size(min = 3, message = "Entrer une chaine d'au moins 3 caractères")
    private String name;

    @Enumerated
    @NotNull(message = "Veuillez précisez votre sex")
    private Gender gender;

    @Enumerated
    @NotNull(message = "Veuillez précisez votre section")
    private Section section;
}
