package com.macina.room.entities.WorkoutPlan;

import com.macina.room.entities.user.UserApp;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T12:19:04+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class WorkoutPlanMapperImpl extends WorkoutPlanMapper {

    @Override
    public WorkoutPlanDTO toDto(WorkoutPlan entity) {
        if ( entity == null ) {
            return null;
        }

        WorkoutPlanDTO workoutPlanDTO = new WorkoutPlanDTO();

        workoutPlanDTO.setUserId( entityUserId( entity ) );
        workoutPlanDTO.setId( entity.getId() );
        workoutPlanDTO.setCreatedAt( entity.getCreatedAt() );
        workoutPlanDTO.setUpdatedAt( entity.getUpdatedAt() );
        workoutPlanDTO.setName( entity.getName() );
        workoutPlanDTO.setStartDate( entity.getStartDate() );
        workoutPlanDTO.setEndDate( entity.getEndDate() );
        workoutPlanDTO.setIsActive( entity.getIsActive() );
        workoutPlanDTO.setIsBuiltFromUser( entity.getIsBuiltFromUser() );

        return workoutPlanDTO;
    }

    @Override
    public WorkoutPlan toEntity(WorkoutPlanDTO dto) {
        if ( dto == null ) {
            return null;
        }

        WorkoutPlan workoutPlan = new WorkoutPlan();

        workoutPlan.setId( dto.getId() );
        workoutPlan.setCreatedAt( dto.getCreatedAt() );
        workoutPlan.setUpdatedAt( dto.getUpdatedAt() );
        workoutPlan.setName( dto.getName() );
        workoutPlan.setStartDate( dto.getStartDate() );
        workoutPlan.setEndDate( dto.getEndDate() );
        workoutPlan.setIsActive( dto.getIsActive() );
        workoutPlan.setIsBuiltFromUser( dto.getIsBuiltFromUser() );

        return workoutPlan;
    }

    private Long entityUserId(WorkoutPlan workoutPlan) {
        UserApp user = workoutPlan.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }
}
