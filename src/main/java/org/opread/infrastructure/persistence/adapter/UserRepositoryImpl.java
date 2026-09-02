package org.opread.infrastructure.persistence.adapter;

import org.opread.domain.model.User;
import org.opread.domain.repository.IUserRepository;
import org.opread.infrastructure.persistence.mapper.UserMapper;
import org.opread.infrastructure.persistence.repository.ISpringDataUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryImpl implements IUserRepository {
    private final ISpringDataUserRepository springDataUserRepository;
    public UserRepositoryImpl(ISpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository =  springDataUserRepository;
    }

    @Override
    public User save(User user) {
        var userToSave = UserMapper.toEntity(user);
        var savedUser = springDataUserRepository.save(userToSave);
        return UserMapper.toDomain(savedUser);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return springDataUserRepository.findById(id).map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email).map(UserMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        boolean result = findByEmail(email).isPresent();
        if (result) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteById(UUID id) {
        springDataUserRepository.deleteById(id);
    }
}
