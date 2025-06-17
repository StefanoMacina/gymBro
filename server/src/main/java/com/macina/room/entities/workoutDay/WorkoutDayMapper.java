package com.macina.room.entities.workoutDay;

import com.macina.room.entities.workoutDayExercise.WorkoutDayExerciseMapper;
import com.macina.room.mapper.EntityMapperUtil;
import com.macina.room.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {WorkoutDayExerciseMapper.class, EntityMapperUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public abstract class WorkoutDayMapper implements GenericMapper<WorkoutDayDTO, WorkoutDay> {

    @Mapping(target = "workoutPlanId", source = "workoutPlan.id")
    @Mapping(target = "exercises", source = "exercises")
    public abstract WorkoutDayDTO toDto(WorkoutDay entity);

    @Mapping(target = "workoutPlan", ignore = true)
    @Mapping(target = "exercises", ignore = true)
    public abstract WorkoutDay toEntity(WorkoutDayDTO dto);

    @Override
    public WorkoutDayDTO updateEntityFromDto(WorkoutDayDTO dto, WorkoutDay entity) {
        if(dto.getSequence() > 0)
            entity.setSequence(dto.getSequence());
        if(dto.getName() != null)
            entity.setName(dto.getName());
        return toDto(entity);
    }
}