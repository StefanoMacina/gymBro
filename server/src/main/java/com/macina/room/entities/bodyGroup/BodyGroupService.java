package com.macina.room.entities.bodyGroup;

import com.macina.room.service.NameableServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BodyGroupService extends NameableServiceImpl<BodyGroupDTO, BodyGroup> {
    public BodyGroupService(BodyGroupRepository repository, BodyGroupMapper mapper) {
        super(repository, mapper);
    }
}