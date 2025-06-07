package com.macina.room.entities.WorkoutPlan;

import com.macina.room.entities.user.UserApp;
import com.macina.room.entities.workoutDay.WorkoutDay;
import com.macina.room.entities.workoutDay.WorkoutDayDTO;
import com.macina.room.entities.workoutDay.WorkoutDayMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-07T18:10:39+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class WorkoutPlanMapperImpl extends WorkoutPlanMapper {

    @Autowired
    private WorkoutDayMapper workoutDayMapper;

    @Override
    public WorkoutPlanDTO toDto(WorkoutPlan entity) {
        if ( entity == null ) {
            return null;
        }

        WorkoutPlanDTO workoutPlanDTO = new WorkoutPlanDTO();

        workoutPlanDTO.setUserId( entityUserId( entity ) );
        workoutPlanDTO.setDays( workoutDayListToWorkoutDayDTOList( entity.getDays() ) );
        workoutPlanDTO.setId( entity.getId() );
        workoutPlanDTO.setCreatedAt( entity.getCreatedAt() );
        workoutPlanDTO.setUpdatedAt( entity.getUpdatedAt() );
        workoutPlanDTO.setName( entity.getName() );

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

        return workoutPlan;
    }

    private Long entityUserId(WorkoutPlan workoutPlan) {
        UserApp user = workoutPlan.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    protected List<WorkoutDayDTO> workoutDayListToWorkoutDayDTOList(List<WorkoutDay> list) {
        if ( list == null ) {
            return null;
        }

        List<WorkoutDayDTO> list1 = new ArrayList<WorkoutDayDTO>( list.size() );
        for ( WorkoutDay workoutDay : list ) {
            list1.add( workoutDayMapper.toDto( workoutDay ) );
        }

        return list1;
    }
}
