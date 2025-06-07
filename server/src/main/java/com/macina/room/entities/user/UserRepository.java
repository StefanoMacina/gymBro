package com.macina.room.entities.user;

import com.macina.room.crud.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<UserApp> {
    boolean existsByUsername(String username);
}
