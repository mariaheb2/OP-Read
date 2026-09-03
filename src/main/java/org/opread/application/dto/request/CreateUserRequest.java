package org.opread.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "O nome de usuário é obrigatório")
        @Size(min = 3, max = 30, message = "O nome de usuário deve ter entre 3 e 30 caracteres")
        String username,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Forneça um e-mail válido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
        String password
) {}