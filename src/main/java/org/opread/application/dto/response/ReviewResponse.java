package org.opread.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReviewResponse(
        UUID id,
        Integer rating,
        String comment,
        LocalDateTime createdAt,
        String username,
        String bookTitle
) {
}
