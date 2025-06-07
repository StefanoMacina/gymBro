package com.macina.room.mapper;

import com.macina.room.crud.BaseDTO;
import com.macina.room.crud.BaseEntity;

public interface GenericMapper<D extends BaseDTO, E extends BaseEntity> {
    E toEntity(D dto);
    D toDto(E entity);
    D updateEntityFromDto(D dto, E entity);
}