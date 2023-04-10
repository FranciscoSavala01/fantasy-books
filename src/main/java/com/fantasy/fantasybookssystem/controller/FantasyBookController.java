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

import java.util.List;

@RestController
@RequestMapping("/fantasy-books")
public class FantasyBookController {
    @Autowired
    private FantasyBookService fantasyBookService;


    @PostMapping
    public ResponseEntity<FantasyBook> createFantasyBook(@RequestParam String name,
                                                         @RequestParam String description,
                                                         @RequestParam MultipartFile image,
                                                         @RequestParam Long author){
        return ResponseEntity.ok(fantasyBookService.createFantasyBook(name, description, image, author));
    }

    @PostMapping("/image")
    public ResponseEntity<String> tryingImage(@RequestParam MultipartFile file){
        return ResponseEntity.ok("OKAY");
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<FantasyBook> fetchFantasyBook(@PathVariable("idBook") Long book){
        return ResponseEntity.ok(fantasyBookService.fetchBook(book));
    }

    @GetMapping
    public ResponseEntity<List<FantasyBook>> fetchAllBooks(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                           @RequestParam(value = "length", defaultValue = "10") Integer length){
        return ResponseEntity.ok(fantasyBookService.fetchBooks(offset, length));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class FantasyBookRequest{
        private String name;
        private String description;
        private MultipartFile image;
        private Long author;
    }
}
