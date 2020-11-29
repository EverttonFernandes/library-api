package com.evertonfernandes.libraryapi.model.repository;

import com.evertonfernandes.libraryapi.model.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um livro na base com o isbn informado.")
    void returnTrueWhenIsbnExists() {
        String isbn = "123";
        Book book = Book.builder().title("As aventuras").author("Fulano").isbn(isbn).build();
        testEntityManager.persist(book);

        boolean exists = bookRepository.existsByIsbn(isbn);

        assertThat(exists).isTrue();
    }

    @Test
    @DisplayName("Deve retornar falso quando existir um livro na base com o isbn informado.")
    void returnFalseWhenIsbnExists() {
        String isbn = "123";

        boolean exists = bookRepository.existsByIsbn(isbn);

        assertThat(exists).isFalse();
    }
}