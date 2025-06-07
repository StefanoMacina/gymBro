package com.macina.room.crud;

import com.macina.room.mapper.GenericMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class GenericServiceImpl<D extends BaseDTO, E extends BaseEntity> implements GenericService<D, E> {

    @Autowired
    GenericRepository<E> repository;
    protected final GenericMapper<D, E> mapper;

    public GenericServiceImpl(GenericRepository<E> repository, GenericMapper<D, E> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public D create(D dto) {
        E entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    @Transactional
    public D getById(Long id) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    @Transactional
    public Page<D> getAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }



    @Override
    @Transactional
    public D update(Long id, D dto) {
        E existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));

        D newDto = mapper.updateEntityFromDto(dto, existingEntity);
        existingEntity = repository.save(existingEntity);

        return mapper.toDto(existingEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        repository.delete(entity);
    }

    @Override
    @Transactional
    public void deleteAll(List<Long> ids){
        List<E> entities = repository.findAllById(ids);
        repository.deleteAll(entities);
    }
}