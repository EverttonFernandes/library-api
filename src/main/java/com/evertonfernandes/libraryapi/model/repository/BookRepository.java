package com.evertonfernandes.libraryapi.model.repository;

import com.evertonfernandes.libraryapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
