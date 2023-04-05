package com.fantasy.fantasybookssystem.service;

import com.fantasy.fantasybookssystem.model.Author;
import com.fantasy.fantasybookssystem.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private IAuthorRepository authorRepository;
    public Author save(Author author){
        Author newAuthor = Author.builder()
                .biography(author.getBiography())
                .name(author.getName())
                .build();
        return authorRepository.save(author);
    }

    public List<Author> fetchByName(String name) {
        List<Author> op = authorRepository.findAllByNameContainingIgnoreCase(name);
        return op;
    }
}
