package com.fantasy.fantasybookssystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "biography", length = 65536)
    private String biography;

    @JsonBackReference
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<FantasyBook> books;

    public Integer countBooks(){
        return books.size();
    }
}
