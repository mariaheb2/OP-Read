package org.opread.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private UUID id;
    private String googleBooksId;
    private String title;
    private String author;
    private String cover_url;
    private Set<Tags> tag;

}
