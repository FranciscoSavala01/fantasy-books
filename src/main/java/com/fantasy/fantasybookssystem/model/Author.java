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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "biography", length = 65536)
    private String biography;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<FantasyBook> books;

    public Integer countBooks(){
        return books.size();
    }
}
