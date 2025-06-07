package com.macina.room.entities.bodyGroup;

import com.macina.room.controller.GenericNameableController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/bodyGroup")
public class BodyGroupController extends GenericNameableController<BodyGroupDTO> {

    public BodyGroupController(BodyGroupService service) {
        super(service);
    }
}