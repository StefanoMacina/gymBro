package com.macina.room.entities.user;

import com.macina.room.entities.WorkoutPlan.WorkoutPlan;
import com.macina.room.entities.WorkoutPlan.WorkoutPlanDTO;
import com.macina.room.entities.bodyGroup.BodyGroup;
import com.macina.room.entities.bodyGroup.BodyGroupDTO;
import com.macina.room.entities.exercise.Exercise;
import com.macina.room.entities.exercise.ExerciseDTO;
import com.macina.room.entities.workoutDay.WorkoutDay;
import com.macina.room.entities.workoutDay.WorkoutDayDTO;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExercise;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExerciseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-07T18:10:39+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public UserDTO toDto(UserApp entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setWorkoutPlans( workoutPlanListToWorkoutPlanDTOList( entity.getWorkoutPlans() ) );
        userDTO.setCreatedAt( entity.getCreatedAt() );
        userDTO.setUpdatedAt( entity.getUpdatedAt() );
        userDTO.setId( entity.getId() );
        userDTO.setUsername( entity.getUsername() );
        userDTO.setEmail( entity.getEmail() );

        return userDTO;
    }

    @Override
    public UserApp toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserApp userApp = new UserApp();

        userApp.setId( dto.getId() );
        userApp.setCreatedAt( dto.getCreatedAt() );
        userApp.setUpdatedAt( dto.getUpdatedAt() );
        userApp.setUsername( dto.getUsername() );
        userApp.setEmail( dto.getEmail() );

        return userApp;
    }

    protected BodyGroupDTO bodyGroupToBodyGroupDTO(BodyGroup bodyGroup) {
        if ( bodyGroup == null ) {
            return null;
        }

        BodyGroupDTO bodyGroupDTO = new BodyGroupDTO();

        bodyGroupDTO.setId( bodyGroup.getId() );
        bodyGroupDTO.setCreatedAt( bodyGroup.getCreatedAt() );
        bodyGroupDTO.setUpdatedAt( bodyGroup.getUpdatedAt() );
        bodyGroupDTO.setName( bodyGroup.getName() );
        bodyGroupDTO.setDescription( bodyGroup.getDescription() );

        return bodyGroupDTO;
    }

    protected ExerciseDTO exerciseToExerciseDTO(Exercise exercise) {
        if ( exercise == null ) {
            return null;
        }

        ExerciseDTO exerciseDTO = new ExerciseDTO();

        exerciseDTO.setId( exercise.getId() );
        exerciseDTO.setCreatedAt( exercise.getCreatedAt() );
        exerciseDTO.setUpdatedAt( exercise.getUpdatedAt() );
        exerciseDTO.setName( exercise.getName() );
        exerciseDTO.setDescription( exercise.getDescription() );
        exerciseDTO.setBodyGroup( bodyGroupToBodyGroupDTO( exercise.getBodyGroup() ) );

        return exerciseDTO;
    }

    protected WorkoutDayExerciseDTO workoutDayExerciseToWorkoutDayExerciseDTO(WorkoutDayExercise workoutDayExercise) {
        if ( workoutDayExercise == null ) {
            return null;
        }

        WorkoutDayExerciseDTO.WorkoutDayExerciseDTOBuilder workoutDayExerciseDTO = WorkoutDayExerciseDTO.builder();

        workoutDayExerciseDTO.sets( workoutDayExercise.getSets() );
        workoutDayExerciseDTO.reps( workoutDayExercise.getReps() );
        workoutDayExerciseDTO.notes( workoutDayExercise.getNotes() );
        workoutDayExerciseDTO.exercise( exerciseToExerciseDTO( workoutDayExercise.getExercise() ) );
        workoutDayExerciseDTO.sequence( workoutDayExercise.getSequence() );

        return workoutDayExerciseDTO.build();
    }

    protected List<WorkoutDayExerciseDTO> workoutDayExerciseListToWorkoutDayExerciseDTOList(List<WorkoutDayExercise> list) {
        if ( list == null ) {
            return null;
        }

        List<WorkoutDayExerciseDTO> list1 = new ArrayList<WorkoutDayExerciseDTO>( list.size() );
        for ( WorkoutDayExercise workoutDayExercise : list ) {
            list1.add( workoutDayExerciseToWorkoutDayExerciseDTO( workoutDayExercise ) );
        }

        return list1;
    }

    protected WorkoutDayDTO workoutDayToWorkoutDayDTO(WorkoutDay workoutDay) {
        if ( workoutDay == null ) {
            return null;
        }

        WorkoutDayDTO workoutDayDTO = new WorkoutDayDTO();

        workoutDayDTO.setId( workoutDay.getId() );
        workoutDayDTO.setCreatedAt( workoutDay.getCreatedAt() );
        workoutDayDTO.setUpdatedAt( workoutDay.getUpdatedAt() );
        workoutDayDTO.setSequence( workoutDay.getSequence() );
        workoutDayDTO.setExercises( workoutDayExerciseListToWorkoutDayExerciseDTOList( workoutDay.getExercises() ) );

        return workoutDayDTO;
    }

    protected List<WorkoutDayDTO> workoutDayListToWorkoutDayDTOList(List<WorkoutDay> list) {
        if ( list == null ) {
            return null;
        }

        List<WorkoutDayDTO> list1 = new ArrayList<WorkoutDayDTO>( list.size() );
        for ( WorkoutDay workoutDay : list ) {
            list1.add( workoutDayToWorkoutDayDTO( workoutDay ) );
        }

        return list1;
    }

    protected WorkoutPlanDTO workoutPlanToWorkoutPlanDTO(WorkoutPlan workoutPlan) {
        if ( workoutPlan == null ) {
            return null;
        }

        WorkoutPlanDTO workoutPlanDTO = new WorkoutPlanDTO();

        workoutPlanDTO.setId( workoutPlan.getId() );
        workoutPlanDTO.setCreatedAt( workoutPlan.getCreatedAt() );
        workoutPlanDTO.setUpdatedAt( workoutPlan.getUpdatedAt() );
        workoutPlanDTO.setName( workoutPlan.getName() );
        workoutPlanDTO.setDays( workoutDayListToWorkoutDayDTOList( workoutPlan.getDays() ) );

        return workoutPlanDTO;
    }

    protected List<WorkoutPlanDTO> workoutPlanListToWorkoutPlanDTOList(List<WorkoutPlan> list) {
        if ( list == null ) {
            return null;
        }

        List<WorkoutPlanDTO> list1 = new ArrayList<WorkoutPlanDTO>( list.size() );
        for ( WorkoutPlan workoutPlan : list ) {
            list1.add( workoutPlanToWorkoutPlanDTO( workoutPlan ) );
        }

        return list1;
    }
}
