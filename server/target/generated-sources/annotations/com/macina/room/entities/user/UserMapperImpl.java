package com.macina.room.entities.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T12:19:04+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public UserDTO toDto(UserApp entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setCreatedAt( entity.getCreatedAt() );
        userDTO.setUpdatedAt( entity.getUpdatedAt() );
        userDTO.setId( entity.getId() );
        userDTO.setUsername( entity.getUsername() );
        userDTO.setEmail( entity.getEmail() );

        return userDTO;
    }

    @Override
    public UserApp toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserApp userApp = new UserApp();

        userApp.setId( dto.getId() );
        userApp.setCreatedAt( dto.getCreatedAt() );
        userApp.setUpdatedAt( dto.getUpdatedAt() );
        userApp.setUsername( dto.getUsername() );
        userApp.setEmail( dto.getEmail() );

        return userApp;
    }
}
