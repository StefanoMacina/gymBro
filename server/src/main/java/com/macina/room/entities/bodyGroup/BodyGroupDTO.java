package com.macina.room.entities.bodyGroup;

import com.macina.room.crud.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class BodyGroupDTO extends BaseDTO {

    private String name;

    private String description;
}
