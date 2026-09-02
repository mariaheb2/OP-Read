package org.opread.domain.repository;

import org.opread.domain.model.CustomList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICustomListRepository {
    CustomList save(CustomList customList);
    Optional<CustomList> findById(UUID id);
    List<CustomList> findByUserId(UUID userId);
    void deleteById(UUID id);
}