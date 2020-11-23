package com.evertonfernandes.libraryapi.service.impl;

import com.evertonfernandes.libraryapi.api.model.entity.Book;
import com.evertonfernandes.libraryapi.api.model.repository.BookRepository;
import com.evertonfernandes.libraryapi.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
