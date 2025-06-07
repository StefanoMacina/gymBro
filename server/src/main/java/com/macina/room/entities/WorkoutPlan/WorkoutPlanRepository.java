package com.macina.room.entities.WorkoutPlan;

import com.macina.room.repository.NameableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutPlanRepository extends NameableRepository<WorkoutPlan> {
    Page<WorkoutPlan> findAllByUser_Id(Pageable pageable, Long id);

}
