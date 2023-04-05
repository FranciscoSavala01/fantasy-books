package com.fantasy.fantasybookssystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionId;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Character {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    private List<Power> power;

    @ManyToOne
    @JoinColumn(name = "fantasy_book")
    private FantasyBook fantasyBook;
}
