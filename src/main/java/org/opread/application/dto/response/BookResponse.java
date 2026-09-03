package org.opread.application.dto.response;

import org.opread.domain.model.Tags;

import java.util.Set;
import java.util.UUID;

public record BookResponse(
        UUID id,
        String googleBooksId,
        String title,
        String author,
        String description,
        String cover_url,
        Set<Tags> tags
) {
}
