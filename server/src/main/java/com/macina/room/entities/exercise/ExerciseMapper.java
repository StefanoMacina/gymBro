package com.macina.room.entities.exercise;

import com.macina.room.entities.bodyGroup.BodyGroupMapper;
import com.macina.room.mapper.EntityMapperUtil;
import com.macina.room.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {BodyGroupMapper.class, EntityMapperUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public abstract class ExerciseMapper implements GenericMapper<ExerciseDTO, Exercise> {

    @Mapping(target = "bodyGroup", source = "bodyGroup")
    public abstract ExerciseDTO toDto(Exercise entity);

    @Mapping(target = "bodyGroup", source = "bodyGroup")
    public abstract Exercise toEntity(ExerciseDTO dto);

    @Override
    public ExerciseDTO updateEntityFromDto(ExerciseDTO dto, Exercise entity) {
        if(dto.getName() != null)
            entity.setName(dto.getName());
        if(dto.getDescription() != null)
            entity.setDescription(dto.getDescription());

        return toDto(entity);
    }
}