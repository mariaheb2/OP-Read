package org.opread.application.dto.request;

import jakarta.validation.constraints.NotNull;
import org.opread.domain.model.Tags;

import java.util.Set;
import java.util.UUID;

public record UpdateBookTagsRequest(
        @NotNull(message = "O ID do livro é obrigatório")
        UUID bookId,

        @NotNull(message = "As tags são obrigatórias")
        Set<Tags> tags
) {
}
