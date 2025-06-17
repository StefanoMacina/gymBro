package com.macina.room.entities.bodyGroup;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T12:19:04+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class BodyGroupMapperImpl extends BodyGroupMapper {

    @Override
    public BodyGroupDTO toDto(BodyGroup entity) {
        if ( entity == null ) {
            return null;
        }

        BodyGroupDTO bodyGroupDTO = new BodyGroupDTO();

        bodyGroupDTO.setId( entity.getId() );
        bodyGroupDTO.setCreatedAt( entity.getCreatedAt() );
        bodyGroupDTO.setUpdatedAt( entity.getUpdatedAt() );
        bodyGroupDTO.setName( entity.getName() );
        bodyGroupDTO.setDescription( entity.getDescription() );

        return bodyGroupDTO;
    }

    @Override
    public BodyGroup toEntity(BodyGroupDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BodyGroup bodyGroup = new BodyGroup();

        bodyGroup.setId( dto.getId() );
        bodyGroup.setCreatedAt( dto.getCreatedAt() );
        bodyGroup.setUpdatedAt( dto.getUpdatedAt() );
        bodyGroup.setName( dto.getName() );
        bodyGroup.setDescription( dto.getDescription() );

        return bodyGroup;
    }
}
