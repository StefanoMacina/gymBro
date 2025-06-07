package com.macina.room.entities.user;

import com.macina.room.crud.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController extends GenericController<UserDTO> {

    public UserController(UserService service) {
        super(service);
    }
}