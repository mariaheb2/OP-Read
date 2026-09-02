package org.opread.infrastructure.persistence.mapper;

import org.opread.domain.model.UserBookReading;
import org.opread.infrastructure.persistence.entity.UserBookReadingEntity;

public class UserBookReadingMapper {

    public static UserBookReading toDomain(UserBookReadingEntity entity) {
        if (entity == null) return null;

        return new UserBookReading(
                entity.getId(),
                UserMapper.toDomain(entity.getUser()),
                BookMapper.toDomain(entity.getBook()),
                entity.getStatus(),
                entity.getUpdatedAt()
        );
    }

    public static UserBookReadingEntity toEntity(UserBookReading domain) {
        if (domain == null) return null;

        return UserBookReadingEntity.builder()
                .id(domain.getId())
                .user(UserMapper.toEntity(domain.getUser()))
                .book(BookMapper.toEntity(domain.getBook()))
                .status(domain.getStatus())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}