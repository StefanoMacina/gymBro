package com.macina.room.entities.exercise;

import com.macina.room.crud.BaseDTO;
import com.macina.room.entities.bodyGroup.BodyGroupDTO;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ExerciseDTO extends BaseDTO {

    private String name;

    private String description;

    private BodyGroupDTO bodyGroup;

}
