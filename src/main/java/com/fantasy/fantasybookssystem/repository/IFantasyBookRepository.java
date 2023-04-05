package com.fantasy.fantasybookssystem.repository;

import com.fantasy.fantasybookssystem.model.FantasyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFantasyBookRepository extends JpaRepository<FantasyBook, Long> {
}
