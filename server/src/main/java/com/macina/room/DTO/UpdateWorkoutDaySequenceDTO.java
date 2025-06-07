package com.macina.room.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UpdateWorkoutDaySequenceDTO {

    private Long workoutDayID;

    private short sequence;

}
