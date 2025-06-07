package com.macina.room.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class ResponseDto<T> {

    private Boolean success;

    private String message;

    private T data;


}
