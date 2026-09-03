package org.opread.application.usecase.user;

import org.opread.application.dto.request.CreateUserRequest;
import org.opread.application.dto.response.UserResponse;
import org.opread.domain.exception.EmailAlreadyExistsException;
import org.opread.domain.model.Role;
import org.opread.domain.model.User;
import org.opread.domain.repository.IUserRepository;
import org.opread.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Service
public class CreateUserUseCase {

    private final IUserRepository userRepository;

    public CreateUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse execute(CreateUserRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new EmailAlreadyExistsException(request.email());
        }
        if (userRepository.findByName(request.username()).isPresent()) {
            throw new IllegalArgumentException("Nome de usuário já em uso.");
        }

        var user = new User(
                UUID.randomUUID(),
                request.username(),
                request.email(),
                request.password(),
                LocalDateTime.now(),
                Role.USER,
                Collections.emptySet()
        );

        var savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getRole()
        );
    }
}
