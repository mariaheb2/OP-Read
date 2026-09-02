package org.opread.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBookReading {
    private UUID id;
    private User user;
    private Book book;
    private ReadingStatus status;
    private LocalDateTime updatedAt;
}
