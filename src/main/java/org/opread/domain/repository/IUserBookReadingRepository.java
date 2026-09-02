package org.opread.domain.repository;

import org.opread.domain.model.ReadingStatus;
import org.opread.domain.model.UserBookReading;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserBookReadingRepository {
    UserBookReading save(UserBookReading userBookReading);
    Optional<UserBookReading> findById(UUID id);
    Optional<UserBookReading> findByUserIdAndBookId(UUID userId, UUID bookId);
    List<UserBookReading> findByUserId(UUID userId);
    List<UserBookReading> findByStatus(ReadingStatus status);
    void deleteById(UUID id);
}