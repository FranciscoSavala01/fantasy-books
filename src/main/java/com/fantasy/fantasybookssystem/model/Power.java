package com.fantasy.fantasybookssystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Power {
    @Id
    private Long id;
    private String name;
    private String description;
    private String image;

    @ManyToMany
    private List<Character> characters;

    @ManyToMany
    private List<Power> counterBy;
}
