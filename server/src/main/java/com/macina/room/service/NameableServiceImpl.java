package com.macina.room.service;

import com.macina.room.crud.BaseDTO;
import com.macina.room.crud.BaseEntity;
import com.macina.room.crud.GenericServiceImpl;
import com.macina.room.interfaces.Nameable;
import com.macina.room.mapper.GenericMapper;
import com.macina.room.repository.NameableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class NameableServiceImpl<D extends BaseDTO, E extends BaseEntity & Nameable>
        extends GenericServiceImpl<D, E> {

    private final NameableRepository<E> nameableRepository;

    public NameableServiceImpl(NameableRepository<E> repository, GenericMapper<D, E> mapper) {
        super(repository, mapper);
        this.nameableRepository = repository;
    }
    public Page<D> findByNameContaining(String name, Pageable pageable) {
        return nameableRepository.findByNameContaining(name, pageable)
                .map(mapper::toDto);
    }

}
