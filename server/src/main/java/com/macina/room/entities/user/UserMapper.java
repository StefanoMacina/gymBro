package com.macina.room.entities.user;

import com.macina.room.mapper.EntityMapperUtil;
import com.macina.room.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = EntityMapperUtil.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public abstract class UserMapper implements GenericMapper<UserDTO, UserApp> {

    @Mapping(target = "workoutPlans", source = "workoutPlans")
    public abstract UserDTO toDto(UserApp entity);

    @Mapping(target = "workoutPlans", ignore = true)
    public abstract UserApp toEntity(UserDTO dto);

    @Override
    public UserDTO updateEntityFromDto(UserDTO dto, UserApp entity) {

        if(dto.getEmail() != null)
            entity.setEmail(dto.getEmail());
        if(dto.getUsername() != null)
            entity.setUsername(dto.getUsername());

        return toDto(entity);
    }


}