package com.macina.room.crud;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<D extends BaseDTO, E extends BaseEntity> {
    D create(D dto);
    D getById(Long id);
    Page<D> getAll(Pageable pageable);
    D update(Long id, D dto);
    void delete(Long id);
    void deleteAll(List<Long> ids);
}
