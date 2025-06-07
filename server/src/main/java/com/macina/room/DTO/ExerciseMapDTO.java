package com.macina.room.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ExerciseMapDTO {

    private long exerciseId;

    private short sequence;

    private short sets;

    private short reps;

    private String note;

}
