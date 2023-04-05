package com.fantasy.fantasybookssystem.controller;

import com.fantasy.fantasybookssystem.model.FantasyBook;
import com.fantasy.fantasybookssystem.service.FantasyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FantasyBookService fantasyBookService;

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("HOLA");
    }

    @GetMapping("/books")
    public ResponseEntity<List<FantasyBook>> books(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return ResponseEntity.ok(fantasyBookService.fetchBooks(offset, limit));
    }
}
