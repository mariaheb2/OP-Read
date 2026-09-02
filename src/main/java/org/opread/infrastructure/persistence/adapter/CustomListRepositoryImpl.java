package org.opread.infrastructure.persistence.adapter;

import org.opread.domain.model.CustomList;
import org.opread.domain.repository.ICustomListRepository;
import org.opread.infrastructure.persistence.mapper.CustomListMapper;
import org.opread.infrastructure.persistence.repository.ISpringDataCustomListRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomListRepositoryImpl implements ICustomListRepository {
    private final ISpringDataCustomListRepository springDataCustomListRepository;
    public CustomListRepositoryImpl(ISpringDataCustomListRepository springDataCustomListRepository) {
        this.springDataCustomListRepository = springDataCustomListRepository;
    }

    @Override
    public CustomList save(CustomList customList) {
        var listToBeSaved = CustomListMapper.toEntity(customList);
        var savedList = springDataCustomListRepository.save(listToBeSaved);
        return CustomListMapper.toDomain(savedList);
    }

    @Override
    public Optional<CustomList> findById(UUID id) {
        return springDataCustomListRepository.findById(id).map(CustomListMapper::toDomain);
    }

    @Override
    public List<CustomList> findByUserId(UUID userId) {
        return springDataCustomListRepository.findByUserId(userId).stream().map(CustomListMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        springDataCustomListRepository.deleteById(id);

    }
}
