package org.opread.infrastructure.persistence.mapper;

import org.opread.domain.model.Book;
import org.opread.infrastructure.persistence.entity.BookEntity;

public class BookMapper {

    public static Book toDomain(BookEntity entity) {
        if (entity == null) return null;

        return new Book(
                entity.getId(),
                entity.getGoogleBooksId(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getDescription(),
                entity.getCoverUrl(),
                entity.getTags()
        );
    }

    public static BookEntity toEntity(Book domain) {
        if (domain == null) return null;

        return BookEntity.builder()
                .id(domain.getId())
                .googleBooksId(domain.getGoogleBooksId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .description(domain.getDescription())
                .coverUrl(domain.getCover_url())
                .tags(domain.getTag())
                .build();
    }
}