package com.macina.room.entities.workoutDay;

import com.macina.room.entities.WorkoutPlan.WorkoutPlan;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExercise;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExerciseDTO;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExerciseMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T12:19:03+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class WorkoutDayMapperImpl extends WorkoutDayMapper {

    @Autowired
    private WorkoutDayExerciseMapper workoutDayExerciseMapper;

    @Override
    public WorkoutDayDTO toDto(WorkoutDay entity) {
        if ( entity == null ) {
            return null;
        }

        WorkoutDayDTO workoutDayDTO = new WorkoutDayDTO();

        workoutDayDTO.setWorkoutPlanId( entityWorkoutPlanId( entity ) );
        workoutDayDTO.setExercises( workoutDayExerciseListToWorkoutDayExerciseDTOList( entity.getExercises() ) );
        workoutDayDTO.setId( entity.getId() );
        workoutDayDTO.setCreatedAt( entity.getCreatedAt() );
        workoutDayDTO.setUpdatedAt( entity.getUpdatedAt() );
        workoutDayDTO.setName( entity.getName() );
        workoutDayDTO.setSequence( entity.getSequence() );

        return workoutDayDTO;
    }

    @Override
    public WorkoutDay toEntity(WorkoutDayDTO dto) {
        if ( dto == null ) {
            return null;
        }

        WorkoutDay workoutDay = new WorkoutDay();

        workoutDay.setId( dto.getId() );
        workoutDay.setCreatedAt( dto.getCreatedAt() );
        workoutDay.setUpdatedAt( dto.getUpdatedAt() );
        workoutDay.setName( dto.getName() );
        workoutDay.setSequence( dto.getSequence() );

        return workoutDay;
    }

    private Long entityWorkoutPlanId(WorkoutDay workoutDay) {
        WorkoutPlan workoutPlan = workoutDay.getWorkoutPlan();
        if ( workoutPlan == null ) {
            return null;
        }
        return workoutPlan.getId();
    }

    protected List<WorkoutDayExerciseDTO> workoutDayExerciseListToWorkoutDayExerciseDTOList(List<WorkoutDayExercise> list) {
        if ( list == null ) {
            return null;
        }

        List<WorkoutDayExerciseDTO> list1 = new ArrayList<WorkoutDayExerciseDTO>( list.size() );
        for ( WorkoutDayExercise workoutDayExercise : list ) {
            list1.add( workoutDayExerciseMapper.toDto( workoutDayExercise ) );
        }

        return list1;
    }
}
