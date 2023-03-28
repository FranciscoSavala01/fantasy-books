package com.fantasy.fantasybookssystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Author {
    @Id
    private Long id;
    private String name;
    private String biography;

    @OneToMany(mappedBy = "id_author")
    private List<FantasyBook> books;
}
