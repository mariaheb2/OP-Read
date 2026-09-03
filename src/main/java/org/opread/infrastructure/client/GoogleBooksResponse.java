package org.opread.infrastructure.client;

import java.util.List;

public record GoogleBooksResponse(
        List<GoogleBooksItem> items
) {
}
