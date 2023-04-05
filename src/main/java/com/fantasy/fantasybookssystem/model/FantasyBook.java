package com.fantasy.fantasybookssystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FantasyBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String description;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    @OneToMany(mappedBy = "id")
    private List<Character> characters;
}
