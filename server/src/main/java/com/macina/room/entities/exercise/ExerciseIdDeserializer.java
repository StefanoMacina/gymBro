package com.macina.room.entities.exercise;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ExerciseIdDeserializer extends JsonDeserializer<ExerciseDTO> {

    @Override
    public ExerciseDTO deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Long exerciseId = p.getLongValue();
        ExerciseDTO dto = new ExerciseDTO();
        dto.setId(exerciseId);
        return dto;
    }
}
