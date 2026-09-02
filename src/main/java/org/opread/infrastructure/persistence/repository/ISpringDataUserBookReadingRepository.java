package org.opread.infrastructure.persistence.repository;

import org.opread.domain.model.ReadingStatus;
import org.opread.infrastructure.persistence.entity.UserBookReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISpringDataUserBookReadingRepository extends JpaRepository<UserBookReadingEntity, UUID> {
    Optional<UserBookReadingEntity> findByUserIdAndBookId(UUID userId, UUID bookId);
    List<UserBookReadingEntity> findByUserId(UUID userId);
    List<UserBookReadingEntity> findByStatus(ReadingStatus status);
}