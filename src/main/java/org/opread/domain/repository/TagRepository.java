package org.opread.domain.repository;

import org.opread.domain.model.Tags;
import java.util.List;
import java.util.Optional;

public interface TagRepository {
    List<Tags> findAll();
    Optional<Tags> findByName(String name);
}