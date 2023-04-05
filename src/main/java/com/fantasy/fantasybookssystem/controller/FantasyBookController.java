package com.fantasy.fantasybookssystem.controller;

import com.fantasy.fantasybookssystem.model.FantasyBook;
import com.fantasy.fantasybookssystem.service.FantasyBookService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fantasy-books")
public class FantasyBookController {
    @Autowired
    private FantasyBookService fantasyBookService;

    @PostMapping
    public ResponseEntity<FantasyBook> createFantasyBook(@RequestBody FantasyBookRequest f){

        return ResponseEntity.ok(fantasyBookService.createFantasyBook(f.getName(), f.getDescription(), f.getImage(), f.getAuthor()));
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<FantasyBook> fetchFantasyBook(@PathVariable("idBook") Long book){
        return ResponseEntity.ok(fantasyBookService.fetchBook(book));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FantasyBookRequest{
        private String name;
        private String description;
        private MultipartFile image;
        private Long author;
    }
}
