package com.macina.room.mapper;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityMapperUtil {
    
    @Autowired
    private EntityManager entityManager;
    
    public <T> T resolve(Long id, Class<T> entityClass) {
        return id != null ? entityManager.getReference(entityClass, id) : null;
    }
}