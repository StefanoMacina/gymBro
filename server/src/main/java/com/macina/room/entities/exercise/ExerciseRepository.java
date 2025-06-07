package com.macina.room.entities.exercise;

import com.macina.room.repository.NameableRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends NameableRepository<Exercise> {

    boolean existsByName(String name);


}
