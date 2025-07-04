package com.macina.room.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AddExercisesDTO {

    private long workoutDay;

    private List<ExerciseMapDTO> exercises;
}

