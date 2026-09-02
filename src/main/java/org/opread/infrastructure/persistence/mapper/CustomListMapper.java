package org.opread.infrastructure.persistence.mapper;

import org.opread.domain.model.Book;
import org.opread.domain.model.CustomList;
import org.opread.infrastructure.persistence.entity.CustomListEntity;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomListMapper {

    public static CustomList toDomain(CustomListEntity entity) {
        if (entity == null) return null;

        Set<Book> books = (entity.getBooks() != null) ?
                entity.getBooks().stream()
                        .map(BookMapper::toDomain)
                        .collect(Collectors.toSet()) : Collections.emptySet();

        return new CustomList(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCreatedAt(),
                books,
                UserMapper.toDomain(entity.getUser())
        );
    }

    public static CustomListEntity toEntity(CustomList domain) {
        if (domain == null) return null;

        return CustomListEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .createdAt(domain.getCreatedAt())
                .books(domain.getBooks() != null ?
                        domain.getBooks().stream()
                                .map(BookMapper::toEntity)
                                .collect(Collectors.toSet()) : Collections.emptySet())
                .user(UserMapper.toEntity(domain.getUserId()))
                .build();
    }
}