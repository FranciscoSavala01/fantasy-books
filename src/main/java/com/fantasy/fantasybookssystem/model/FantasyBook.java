package com.fantasy.fantasybookssystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FantasyBook {
    @Id
    private Long id;

    private String name;
    private String image;
    private String description;

    @ManyToOne
    private Author author;
}
