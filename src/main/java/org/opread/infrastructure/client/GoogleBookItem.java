package org.opread.infrastructure.client;

public record GoogleBookItem(
        String id,
        VolumeInfo volumeInfo
) {
}
