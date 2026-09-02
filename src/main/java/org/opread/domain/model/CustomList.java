package org.opread.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomList {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Set<Book> books = new HashSet<>();
    private User userId;

}
