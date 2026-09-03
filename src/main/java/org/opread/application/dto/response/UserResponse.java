package org.opread.application.dto.response;

import org.opread.domain.model.Role;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        LocalDateTime createdAt,
        Role role
) {}