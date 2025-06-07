package com.macina.room.repository;

import com.macina.room.crud.BaseEntity;
import com.macina.room.crud.GenericRepository;
import com.macina.room.interfaces.Nameable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface NameableRepository<T extends BaseEntity & Nameable> extends GenericRepository<T> {
    Page<T> findByNameContaining(String name, Pageable pageable);
}