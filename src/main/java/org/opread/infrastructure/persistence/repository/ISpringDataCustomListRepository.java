package org.opread.infrastructure.persistence.repository;

import org.opread.domain.model.CustomList;
import org.opread.infrastructure.persistence.entity.CustomListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ISpringDataCustomListRepository extends JpaRepository<CustomListEntity, UUID> {
    List<CustomListEntity> findByUserId(UUID userId);

}
