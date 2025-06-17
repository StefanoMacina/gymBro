package com.macina.room.entities.workoutDay;

import com.macina.room.crud.GenericRepository;
import com.macina.room.entities.WorkoutPlan.WorkoutPlan;
import com.macina.room.repository.NameableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutDayRepository extends NameableRepository<WorkoutDay> {
    Page<WorkoutDay> findAllByWorkoutPlan_Id(Pageable pageable, Long id);

}
