package org.opread.infrastructure.persistence.adapter;

import org.opread.domain.model.ReadingStatus;
import org.opread.domain.model.UserBookReading;
import org.opread.domain.repository.IUserBookReadingRepository;
import org.opread.infrastructure.persistence.mapper.UserBookReadingMapper;
import org.opread.infrastructure.persistence.repository.ISpringDataUserBookReadingRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserBookReadingRepositoryImpl implements IUserBookReadingRepository {

    private final ISpringDataUserBookReadingRepository springDataUserBookReadingRepository;

    public UserBookReadingRepositoryImpl(ISpringDataUserBookReadingRepository springDataUserBookReadingRepository) {
        this.springDataUserBookReadingRepository = springDataUserBookReadingRepository;
    }

    @Override
    public UserBookReading save(UserBookReading userBookReading) {
        var entityToSave = UserBookReadingMapper.toEntity(userBookReading);
        var savedEntity = springDataUserBookReadingRepository.save(entityToSave);
        return UserBookReadingMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<UserBookReading> findById(UUID id) {
        return springDataUserBookReadingRepository.findById(id)
                .map(UserBookReadingMapper::toDomain);
    }

    @Override
    public List<UserBookReading> findByUserId(UUID userId) {
        return springDataUserBookReadingRepository.findByUserId(userId)
                .stream()
                .map(UserBookReadingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserBookReading> findByStatus(ReadingStatus status) {
        return springDataUserBookReadingRepository.findByStatus(status)
                .stream()
                .map(UserBookReadingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserBookReading> findByUserIdAndBookId(UUID userId, UUID bookId) {
        return springDataUserBookReadingRepository.findByUserIdAndBookId(userId, bookId)
                .map(UserBookReadingMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        springDataUserBookReadingRepository.deleteById(id);
    }
}