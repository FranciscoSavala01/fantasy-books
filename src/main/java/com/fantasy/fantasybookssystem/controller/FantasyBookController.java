package com.fantasy.fantasybookssystem.controller;

import com.fantasy.fantasybookssystem.model.FantasyBook;
import com.fantasy.fantasybookssystem.service.FantasyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fantasy-book")
public class FantasyBookController {
    @Autowired
    private FantasyBookService fantasyBookService;

    //holas asd ags
    @PostMapping
    public ResponseEntity<FantasyBook> createFantasyBook(@RequestParam(value = "name") String name,
                                                         @RequestParam(value = "description", required = false) String description,
                                                         @RequestParam(value = "image", required = false) MultipartFile image,
                                                         @RequestParam(value = "author") String idAuthor){

        return ResponseEntity.ok(fantasyBookService.createFantasyBook(name, description, image, Long.parseLong(idAuthor)));
    }

}
