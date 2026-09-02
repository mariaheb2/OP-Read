package org.opread.infrastructure.persistence.adapter;

import org.opread.domain.model.Review;
import org.opread.domain.repository.IReviewRepository;
import org.opread.infrastructure.persistence.mapper.ReviewMapper;
import org.opread.infrastructure.persistence.repository.ISpringDataReviewRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ReviewRepositoryImpl implements IReviewRepository {
    private final ISpringDataReviewRepository springDataReviewRepository;
    public ReviewRepositoryImpl(ISpringDataReviewRepository springDataReviewRepository) {
        this.springDataReviewRepository = springDataReviewRepository;
    }

    @Override
    public Review save(Review review) {
        var reviewEntity = ReviewMapper.toEntity(review);
        var savedReview = springDataReviewRepository.save(reviewEntity);
        return ReviewMapper.toDomain(savedReview);
    }

    @Override
    public Optional<Review> findById(UUID id) {
        return springDataReviewRepository.findById(id).map(ReviewMapper::toDomain);
    }

    @Override
    public List<Review> findByBookId(UUID bookId) {
        return springDataReviewRepository.findByBookId(bookId).stream().map(ReviewMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Review> findByUserId(UUID userId) {
        return springDataReviewRepository.findByUserId(userId).stream().map(ReviewMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        springDataReviewRepository.deleteById(id);

    }
}
