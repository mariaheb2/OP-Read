package org.opread.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.opread.domain.model.Tags;

import java.util.Set;

public record SaveGoogleBookRequest(
        @NotBlank(message = "O id do Google Books é obrigatório")
        String googleBooksId,

        @NotBlank(message = "O título é obrigatório")
        String title,
        String author,
        String description,
        String cover_url,
        Set<Tags> tags

) {
}
