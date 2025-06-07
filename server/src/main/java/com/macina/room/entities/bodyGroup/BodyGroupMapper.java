package com.macina.room.entities.bodyGroup;

import com.macina.room.mapper.EntityMapperUtil;
import com.macina.room.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {EntityMapperUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public abstract class BodyGroupMapper implements GenericMapper<BodyGroupDTO, BodyGroup> {

    //@Mapping(target = "name", source = "name", qualifiedByName = "enumToString")
    public abstract BodyGroupDTO toDto(BodyGroup entity);

    //@Mapping(target = "name", source = "name", qualifiedByName = "stringToEnum")
    public abstract BodyGroup toEntity(BodyGroupDTO dto);

    @Override
    public BodyGroupDTO updateEntityFromDto(BodyGroupDTO dto, BodyGroup entity) {
        if (dto.getDescription() != null)
            entity.setDescription(dto.getDescription());
        if (dto.getName() != null)
            entity.setName(dto.getName());

        return toDto(entity);
    }

}