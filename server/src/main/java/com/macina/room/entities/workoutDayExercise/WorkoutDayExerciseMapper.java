package com.macina.room.entities.workoutDayExercise;

import com.macina.room.entities.exercise.ExerciseMapper;
import com.macina.room.mapper.EntityMapperUtil;
import com.macina.room.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {ExerciseMapper.class, EntityMapperUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public abstract class WorkoutDayExerciseMapper implements GenericMapper<WorkoutDayExerciseDTO, WorkoutDayExercise> {

    @Mapping(target = "workoutDayId", source = "workoutDay.id")
    @Mapping(target = "exercise", source = "exercise")
    //@Mapping(target = "exercise", source = "exercise")
    public abstract WorkoutDayExerciseDTO toDto(WorkoutDayExercise entity);

    @Mapping(target = "workoutDay", ignore = true)
    @Mapping(target = "exercise", ignore = true)
    public abstract WorkoutDayExercise toEntity(WorkoutDayExerciseDTO dto);

    @Override
    public WorkoutDayExerciseDTO updateEntityFromDto(WorkoutDayExerciseDTO dto, WorkoutDayExercise entity) {
        if(dto.getSets() != null)
            entity.setSets(dto.getSets());
        if(dto.getReps() != null)
            entity.setReps(dto.getReps());
        if(dto.getNotes() != null)
            entity.setNotes(dto.getNotes());
        if(dto.getSequence() != null)
            entity.setSequence(dto.getSequence());


        return toDto(entity);
    }
}