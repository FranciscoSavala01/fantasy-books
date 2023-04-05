package com.fantasy.fantasybookssystem.model;

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

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    @OneToMany(mappedBy = "id")
    private List<Character> characters;
}
