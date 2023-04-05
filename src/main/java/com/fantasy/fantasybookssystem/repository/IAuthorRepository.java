package com.fantasy.fantasybookssystem.repository;

import com.fantasy.fantasybookssystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByNameContainingIgnoreCase(String name);
}
