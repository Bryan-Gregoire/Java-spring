package com.example.demo.security;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

    @Id
    private String username;
    private String password;
    private boolean enabled;
}
