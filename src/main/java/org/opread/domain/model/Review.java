package org.opread.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.opread.domain.exception.InvalidRatingException;

import java.security.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private UUID id;
    private Integer rating;
    private String comment;
    private Timestamp createdAt;
    private Book bookId;
    private User userId;

    private void validateRating(Integer rating) {
        if (rating == null || rating < 1 || rating > 5) {
            throw new InvalidRatingException(rating);
        }
    }
}
