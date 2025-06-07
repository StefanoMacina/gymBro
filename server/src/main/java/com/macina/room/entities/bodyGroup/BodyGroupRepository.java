package com.macina.room.entities.bodyGroup;

import com.macina.room.repository.NameableRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BodyGroupRepository extends NameableRepository<BodyGroup> {
    Boolean existsByName(String name);
    Optional<BodyGroup> findByName(String name);

}
