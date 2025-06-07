package com.macina.room.entities.workoutDay;

import com.macina.room.crud.BaseDTO;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExerciseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDayDTO extends BaseDTO {
    private short sequence;
    private Long workoutPlanId;
    private List<WorkoutDayExerciseDTO> exercises;
}