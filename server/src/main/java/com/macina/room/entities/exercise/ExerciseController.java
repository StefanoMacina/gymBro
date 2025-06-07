package com.macina.room.entities.exercise;

import com.macina.room.controller.GenericNameableController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController extends GenericNameableController<ExerciseDTO> {

    @Autowired
    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService service) {
        super(service);
    }
}
