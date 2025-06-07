package com.macina.room.entities.workoutDayExercise;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.macina.room.crud.BaseDTO;
import com.macina.room.entities.exercise.ExerciseDTO;
import com.macina.room.entities.exercise.ExerciseIdDeserializer;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutDayExerciseDTO extends BaseDTO {
    private Integer sets;
    private Integer reps;
    private String notes;
    private Long workoutDayId;

    @JsonDeserialize(using = ExerciseIdDeserializer.class)
    private ExerciseDTO exercise;

    private Short sequence;
}