package com.fantasy.fantasybookssystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Power {
    @Id
    private Long id;
    private String name;
    private String description;
}
