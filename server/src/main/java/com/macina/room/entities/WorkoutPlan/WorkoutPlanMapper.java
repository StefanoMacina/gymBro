package com.macina.room.entities.WorkoutPlan;

import com.macina.room.entities.workoutDay.WorkoutDayMapper;
import com.macina.room.mapper.EntityMapperUtil;
import com.macina.room.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {WorkoutDayMapper.class, EntityMapperUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public abstract class WorkoutPlanMapper implements GenericMapper<WorkoutPlanDTO, WorkoutPlan> {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "days", source = "days")
    public abstract WorkoutPlanDTO toDto(WorkoutPlan entity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "days", ignore = true)
    public abstract WorkoutPlan toEntity(WorkoutPlanDTO dto);

    @Override
    public WorkoutPlanDTO updateEntityFromDto(WorkoutPlanDTO dto, WorkoutPlan entity) {
        if (dto.getName() != null)
            entity.setName(dto.getName());

        return toDto(entity);
    }
}