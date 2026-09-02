package org.opread.domain.repository;

import org.opread.domain.model.Review;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IReviewRepository {
    Review save(Review review);
    Optional<Review> findById(UUID id);
    List<Review> findByBookId(UUID bookId);
    List<Review> findByUserId(UUID userId);
    void deleteById(UUID id);
}