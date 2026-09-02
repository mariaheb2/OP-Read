package org.opread.infrastructure.persistence.mapper;

import org.opread.domain.model.Review;
import org.opread.infrastructure.persistence.entity.ReviewEntity;

public class ReviewMapper {

    public static Review toDomain(ReviewEntity entity) {
        if (entity == null) return null;

        return new Review(
                entity.getId(),
                entity.getRating(),
                entity.getComment(),
                entity.getCreatedAt(),
                BookMapper.toDomain(entity.getBook()),
                UserMapper.toDomain(entity.getUser())
        );
    }

    public static ReviewEntity toEntity(Review domain) {
        if (domain == null) return null;

        return ReviewEntity.builder()
                .id(domain.getId())
                .rating(domain.getRating())
                .comment(domain.getComment())
                .createdAt(domain.getCreatedAt())
                .user(UserMapper.toEntity(domain.getUserId()))
                .book(BookMapper.toEntity(domain.getBookId()))
                .build();
    }
}