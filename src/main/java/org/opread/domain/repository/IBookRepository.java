package org.opread.domain.repository;

import org.opread.domain.model.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(UUID id);
    Optional<Book> findByGoogleBooksId(String googleBooksId);
    List<Book> findAll();
    void deleteById(UUID id);
}