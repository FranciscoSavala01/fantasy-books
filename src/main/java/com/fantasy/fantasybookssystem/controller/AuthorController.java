package com.fantasy.fantasybookssystem.controller;

import com.fantasy.fantasybookssystem.error.EntityErrorResponse;
import com.fantasy.fantasybookssystem.error.EntityNotFoundException;
import com.fantasy.fantasybookssystem.model.Author;
import com.fantasy.fantasybookssystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.save(author));
    }


    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<Author>> fetchAuthorByName(@PathVariable("authorName") String name){
        List<Author> authors = authorService.fetchByName(name);
        if(authors.size() == 0) throw new EntityNotFoundException("No se encontró el autor con el nombre " + name);
        return ResponseEntity.ok(authors);
    }



    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> exceptionHandler(EntityNotFoundException notFoundException){
        EntityErrorResponse response = new EntityErrorResponse();
        response.setMessage(notFoundException.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
