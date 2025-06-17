package com.macina.room.entities.workoutDayExercise;

import com.macina.room.entities.exercise.ExerciseMapper;
import com.macina.room.entities.workoutDay.WorkoutDay;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T12:19:04+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class WorkoutDayExerciseMapperImpl extends WorkoutDayExerciseMapper {

    @Autowired
    private ExerciseMapper exerciseMapper;

    @Override
    public WorkoutDayExerciseDTO toDto(WorkoutDayExercise entity) {
        if ( entity == null ) {
            return null;
        }

        WorkoutDayExerciseDTO workoutDayExerciseDTO = new WorkoutDayExerciseDTO();

        workoutDayExerciseDTO.setWorkoutDayId( entityWorkoutDayId( entity ) );
        workoutDayExerciseDTO.setExercise( exerciseMapper.toDto( entity.getExercise() ) );
        workoutDayExerciseDTO.setId( entity.getId() );
        workoutDayExerciseDTO.setCreatedAt( entity.getCreatedAt() );
        workoutDayExerciseDTO.setUpdatedAt( entity.getUpdatedAt() );
        workoutDayExerciseDTO.setSets( entity.getSets() );
        workoutDayExerciseDTO.setReps( entity.getReps() );
        workoutDayExerciseDTO.setNotes( entity.getNotes() );
        workoutDayExerciseDTO.setSequence( entity.getSequence() );

        return workoutDayExerciseDTO;
    }

    @Override
    public WorkoutDayExercise toEntity(WorkoutDayExerciseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        WorkoutDayExercise.WorkoutDayExerciseBuilder workoutDayExercise = WorkoutDayExercise.builder();

        if ( dto.getSets() != null ) {
            workoutDayExercise.sets( dto.getSets() );
        }
        if ( dto.getReps() != null ) {
            workoutDayExercise.reps( dto.getReps() );
        }
        workoutDayExercise.notes( dto.getNotes() );
        if ( dto.getSequence() != null ) {
            workoutDayExercise.sequence( dto.getSequence() );
        }

        return workoutDayExercise.build();
    }

    private Long entityWorkoutDayId(WorkoutDayExercise workoutDayExercise) {
        WorkoutDay workoutDay = workoutDayExercise.getWorkoutDay();
        if ( workoutDay == null ) {
            return null;
        }
        return workoutDay.getId();
    }
}
