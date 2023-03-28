package com.fantasy.fantasybookssystem.service;

import com.fantasy.fantasybookssystem.model.FantasyBook;

import java.util.List;

public interface IFantasyBookService {
    String fetchBooks();

    List<FantasyBook> fetchBooks(Integer offset, Integer limit);
}
