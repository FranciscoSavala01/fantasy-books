package com.fantasy.fantasybookssystem.service;

import com.fantasy.fantasybookssystem.model.FantasyBook;
import com.fantasy.fantasybookssystem.repository.IFantasyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FantasyBookServiceImpl implements IFantasyBookService{

    @Autowired
    private IFantasyBookRepository repository;


    @Override
    public String fetchBooks() {
        return null;
    }

    @Override
    public List<FantasyBook> fetchBooks(Integer offset, Integer limit) {
        return repository.findAll();
    }
}
