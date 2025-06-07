package com.macina.room.entities.exercise;

import com.macina.room.entities.bodyGroup.BodyGroupMapper;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-07T18:10:39+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ExerciseMapperImpl extends ExerciseMapper {

    @Autowired
    private BodyGroupMapper bodyGroupMapper;

    @Override
    public ExerciseDTO toDto(Exercise entity) {
        if ( entity == null ) {
            return null;
        }

        ExerciseDTO exerciseDTO = new ExerciseDTO();

        exerciseDTO.setBodyGroup( bodyGroupMapper.toDto( entity.getBodyGroup() ) );
        exerciseDTO.setId( entity.getId() );
        exerciseDTO.setCreatedAt( entity.getCreatedAt() );
        exerciseDTO.setUpdatedAt( entity.getUpdatedAt() );
        exerciseDTO.setName( entity.getName() );
        exerciseDTO.setDescription( entity.getDescription() );

        return exerciseDTO;
    }

    @Override
    public Exercise toEntity(ExerciseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Exercise exercise = new Exercise();

        exercise.setBodyGroup( bodyGroupMapper.toEntity( dto.getBodyGroup() ) );
        exercise.setId( dto.getId() );
        exercise.setCreatedAt( dto.getCreatedAt() );
        exercise.setUpdatedAt( dto.getUpdatedAt() );
        exercise.setName( dto.getName() );
        exercise.setDescription( dto.getDescription() );

        return exercise;
    }
}
