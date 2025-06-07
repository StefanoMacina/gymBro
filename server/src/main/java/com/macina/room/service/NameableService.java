package com.macina.room.service;

import com.macina.room.crud.BaseDTO;
import com.macina.room.crud.BaseEntity;
import com.macina.room.interfaces.Nameable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface NameableService <D extends BaseDTO, E extends BaseEntity & Nameable> {
    Page<D> findByNameContaining(String name, Pageable pageable);

}
