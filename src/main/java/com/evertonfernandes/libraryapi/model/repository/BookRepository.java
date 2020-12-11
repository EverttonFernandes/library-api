package com.evertonfernandes.libraryapi.model.repository;

import com.evertonfernandes.libraryapi.model.entity.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);

    Page<Book> findAll(Example<Book> example, Pageable pageRequest);
}
