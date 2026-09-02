package org.opread.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private Role role;
    private Set<Book> favoriteBooks;

    public User() {
        this.role = Role.USER;
        this.createdAt = LocalDateTime.now();
        this.favoriteBooks = new HashSet<>();
    }

    public boolean isAdmin() {
        if (this.role == Role.ADMIN) {
            return true;
        }
        return false;
    }

}
