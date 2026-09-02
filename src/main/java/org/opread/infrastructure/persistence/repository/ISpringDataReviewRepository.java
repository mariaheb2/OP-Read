package org.opread.infrastructure.persistence.repository;

import org.opread.infrastructure.persistence.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ISpringDataReviewRepository extends JpaRepository<ReviewEntity, UUID> {
    Optional<ReviewEntity> findByBookId(UUID bookId);
    Optional<ReviewEntity> findByUserId(UUID userId);
}
