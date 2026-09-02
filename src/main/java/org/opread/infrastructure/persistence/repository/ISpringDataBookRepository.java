package org.opread.infrastructure.persistence.repository;

import org.opread.infrastructure.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ISpringDataBookRepository extends JpaRepository<BookEntity, UUID> {
    Optional<BookEntity> findByGoogleBooksId(String googleBooksId);
}
