package org.opread.application.usecase.review;

import org.opread.application.dto.request.CreateReviewRequest;
import org.opread.domain.model.Review;
import org.opread.domain.repository.IBookRepository;
import org.opread.domain.repository.IReviewRepository;
import org.opread.domain.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CreateReviewUseCase {
    private final IReviewRepository reviewRepository;
    private final IBookRepository bookRepository;
    private final IUserRepository userRepository;

    public CreateReviewUseCase(IReviewRepository reviewRepository,  IBookRepository bookRepository, IUserRepository userRepository ) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Review execute(CreateReviewRequest request){
        var user = userRepository.findById(request.userId()).orElseThrow(() -> new IllegalArgumentException("user not found"));
        var book = bookRepository.findById(request.bookId()).orElseThrow(() -> new IllegalArgumentException("book not found"));

        var review = new Review(
                UUID.randomUUID(),
                request.rating(),
                request.comment(),
                LocalDateTime.now(),
                book,
                user
        );
        var savedReview = reviewRepository.save(review);
        return new Review(
                savedReview.getId(),
                savedReview.getRating(),
                savedReview.getComment(),
                savedReview.getCreatedAt(),
                savedReview.getBookId(),
                savedReview.getUserId()
        );
    }

}
