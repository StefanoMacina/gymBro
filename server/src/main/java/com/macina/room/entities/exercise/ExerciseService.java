package com.macina.room.entities.exercise;

import com.macina.room.entities.bodyGroup.BodyGroup;
import com.macina.room.entities.bodyGroup.BodyGroupDTO;
import com.macina.room.entities.bodyGroup.BodyGroupRepository;
import com.macina.room.service.NameableServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService extends NameableServiceImpl<ExerciseDTO,Exercise> {

    @Autowired
    private BodyGroupRepository bodyGroupRepository;

    public ExerciseService(ExerciseRepository repository, ExerciseMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @Transactional
    public ExerciseDTO create(ExerciseDTO dto){
        if (dto.getBodyGroup() != null && dto.getBodyGroup().getId() != null) {
            BodyGroup bodyGroup = bodyGroupRepository.findById(dto.getBodyGroup().getId())
                    .orElseThrow(() -> new RuntimeException("BodyGroup not found with id: " + dto.getBodyGroup().getId()));

            BodyGroupDTO bodyGroupDTO = new BodyGroupDTO();
            bodyGroupDTO.setId(bodyGroup.getId());
            bodyGroupDTO.setName(bodyGroup.getName());
            bodyGroupDTO.setDescription(bodyGroup.getDescription());

            dto.setBodyGroup(bodyGroupDTO);
        }
        return super.create(dto);
    }


}
