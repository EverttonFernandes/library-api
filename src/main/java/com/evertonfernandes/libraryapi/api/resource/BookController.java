package com.evertonfernandes.libraryapi.api.resource;

import com.evertonfernandes.libraryapi.api.dto.BookDTO;
import com.evertonfernandes.libraryapi.api.model.entity.Book;
import com.evertonfernandes.libraryapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO bookDTO) {
        Book entity = Book.builder().author(bookDTO.getAuthor()).title(bookDTO.getTitle()).isbn(bookDTO.getIsbn()).build();

        entity = service.save(entity);

        return BookDTO.builder().id(entity.getId()).author(entity.getAuthor()).title(entity.getTitle()).isbn(entity.getIsbn()).build();
    }
}