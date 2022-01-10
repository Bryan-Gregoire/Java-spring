package com.example.demo.security;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Authority {

    @Id
    private long id;
    private String username;
    private String authority;
}
