package com.macina.room.entities.WorkoutPlan;

import com.macina.room.crud.BaseDTO;
import com.macina.room.entities.workoutDay.WorkoutDayDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutPlanDTO extends BaseDTO {

    private String name;

    private Long userId;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean isActive;

    private Boolean isBuiltFromUser;
    //private List<WorkoutDayDTO> days;

}
