package org.opread.infrastructure.persistence.repository;

import org.opread.infrastructure.persistence.entity.CustomListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ISpringDataCustomListRepository extends JpaRepository<CustomListEntity, UUID> {
    Optional<CustomListEntity> findByName(String name);
}
