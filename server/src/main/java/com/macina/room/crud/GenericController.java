package com.macina.room.crud;

import com.macina.room.DTO.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class GenericController<D extends BaseDTO> {

    protected final GenericService<D, ?> service;

    public GenericController(GenericService<D, ?> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<D>> create(@RequestBody D dto) {
        D createdDto = service.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto<>(true, "Entity created successfully", createdDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<D>> getById(@PathVariable Long id) {
        D dto = service.getById(id);
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entity retrieved successfully", dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<Page<D>>> getAll(Pageable pageable) {
        Page<D> dtos = service.getAll(pageable);
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entities retrieved successfully", dtos));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<D>> update(@PathVariable Long id, @RequestBody D dto) {
        D updatedDto = service.update(id, dto);
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entity updated successfully", updatedDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entity deleted successfully", null));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<Void>> deleteInBatch(
            @RequestBody List<Long> ids
            ){
        service.deleteAll(ids);
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entity deleted successfully", null));
    }
}