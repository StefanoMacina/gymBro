package com.macina.room.entities.workoutDayExercise;

import com.macina.room.entities.exercise.ExerciseMapper;
import com.macina.room.entities.workoutDay.WorkoutDay;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-07T18:10:48+0200",
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

        WorkoutDayExerciseDTO.WorkoutDayExerciseDTOBuilder workoutDayExerciseDTO = WorkoutDayExerciseDTO.builder();

        workoutDayExerciseDTO.workoutDayId( entityWorkoutDayId( entity ) );
        workoutDayExerciseDTO.sets( entity.getSets() );
        workoutDayExerciseDTO.reps( entity.getReps() );
        workoutDayExerciseDTO.notes( entity.getNotes() );
        workoutDayExerciseDTO.exercise( exerciseMapper.toDto( entity.getExercise() ) );
        workoutDayExerciseDTO.sequence( entity.getSequence() );

        return workoutDayExerciseDTO.build();
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
