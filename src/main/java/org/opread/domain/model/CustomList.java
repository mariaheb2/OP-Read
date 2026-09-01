package org.opread.domain.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CustomList {
    private UUID id;
    private String name;
    private String description;
    private Set<Book> books = new HashSet<>();
    private User userId;

    public CustomList(){}
}
