package com.fantasy.fantasybookssystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Character {
    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Power> power;
}
