package org.opread.infrastructure.persistence.mapper;

import org.opread.domain.model.Book;
import org.opread.domain.model.User;
import org.opread.infrastructure.persistence.entity.UserEntity;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        Set<Book> favorites = (entity.getFavoriteBooks() != null) ?
                entity.getFavoriteBooks().stream()
                        .map(BookMapper::toDomain)
                        .collect(Collectors.toSet()) : Collections.emptySet();

        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCreatedAt(),
                entity.getRole(),
                favorites
        );
    }

    public static UserEntity toEntity(User domain) {
        if (domain == null) return null;

        return UserEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .email(domain.getEmail())
                .password(domain.getPassword())
                .createdAt(domain.getCreatedAt())
                .role(domain.getRole())
                .favoriteBooks(domain.getFavoriteBooks() != null ?
                        domain.getFavoriteBooks().stream()
                                .map(BookMapper::toEntity)
                                .collect(Collectors.toSet()) : Collections.emptySet())
                .build();
    }
}