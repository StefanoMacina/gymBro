package com.macina.room.entities.user;


import com.macina.room.crud.GenericServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericServiceImpl<UserDTO, UserApp> {

    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

}