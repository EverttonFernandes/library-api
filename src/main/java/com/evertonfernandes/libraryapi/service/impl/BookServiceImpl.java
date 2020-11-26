package com.evertonfernandes.libraryapi.service.impl;

import com.evertonfernandes.libraryapi.exception.BusinessException;
import com.evertonfernandes.libraryapi.model.entity.Book;
import com.evertonfernandes.libraryapi.model.repository.BookRepository;
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
        if (repository.existsByIsbn(book.getIsbn())) {
            throw new BusinessException(("Isbn já cadastrado"));
        }
        return repository.save(book);
    }
}
