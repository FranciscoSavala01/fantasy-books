package com.fantasy.fantasybookssystem.service;

import com.fantasy.fantasybookssystem.error.EntityNotFoundException;
import com.fantasy.fantasybookssystem.model.Author;
import com.fantasy.fantasybookssystem.model.FantasyBook;
import com.fantasy.fantasybookssystem.repository.IAuthorRepository;
import com.fantasy.fantasybookssystem.repository.IFantasyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FantasyBookService {
    private static final String IMAGE_BASE_PATH = "C:\\Users\\tobit\\OneDrive - frc.utn.edu.ar\\FranUni\\frameworks\\spring\\fantasy-books-system\\src\\main\\resources\\static\\img";

    @Autowired
    private IFantasyBookRepository repository;

    @Autowired
    private IAuthorRepository authorRepository;

    public String fetchBooks() {
        return null;
    }

    public List<FantasyBook> fetchBooks(Integer offset, Integer limit) {
        return repository.findAll();
    }

    public FantasyBook createFantasyBook(FantasyBook fantasyBook) {
        return fantasyBook;
    }

    public FantasyBook createFantasyBook(String name, String description, MultipartFile image, Long idAuthor) {
        Optional<Author> authorOptional = authorRepository.findById(idAuthor);
        if(authorOptional.isEmpty()) throw new EntityNotFoundException("No se encontró el autor con el id " + idAuthor);

        Author author = authorOptional.get();

        String pathFile = "";
        if(image != null){
            pathFile = IMAGE_BASE_PATH + image.getOriginalFilename();
            try {
                image.transferTo(new File(pathFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FantasyBook fantasyBook = FantasyBook.builder()
                .name(name)
                .description(description)
                .image(pathFile)
                .author(author)
                .build();

        return repository.save(fantasyBook);
    }

    public FantasyBook fetchBook(Long book) {
        Optional<FantasyBook> opBook = repository.findById(book);
        if(opBook.isEmpty()) throw new EntityNotFoundException("No se encontró el libro con el id " + book);

        return opBook.get();
    }
}
