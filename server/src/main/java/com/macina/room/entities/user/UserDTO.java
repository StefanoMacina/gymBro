package com.macina.room.entities.user;


import com.macina.room.crud.BaseDTO;
import com.macina.room.entities.WorkoutPlan.WorkoutPlanDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor @Getter
@Setter
public class UserDTO extends BaseDTO {

    private Long id;

    private String username;

    private String email;

    //private List<WorkoutPlanDTO> workoutPlans;


}