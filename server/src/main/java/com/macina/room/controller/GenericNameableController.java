package com.macina.room.controller;

import com.macina.room.crud.BaseDTO;
import com.macina.room.crud.GenericController;
import com.macina.room.service.NameableServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class GenericNameableController<D extends BaseDTO> extends GenericController<D> {

    protected final NameableServiceImpl<D, ?> nameableService;

    public GenericNameableController(NameableServiceImpl<D, ?> service) {
        super(service);
        this.nameableService = service;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<D>> searchByName(@RequestParam String name, Pageable pageable) {
        Page<D> result = nameableService.findByNameContaining(name, pageable);
        return ResponseEntity.ok(result);
    }
}