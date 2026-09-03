package org.opread.infrastructure.client;

import java.util.List;

public record VolumeInfo(
        String title,
        List<String> authors,
        String description,
        ImageLinks imageLinks
) {
}
