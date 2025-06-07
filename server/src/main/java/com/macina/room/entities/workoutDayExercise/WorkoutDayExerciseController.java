package com.macina.room.entities.workoutDayExercise;

import com.macina.room.DTO.AddExercisesDTO;
import com.macina.room.DTO.ResponseDto;
import com.macina.room.crud.GenericController;
import com.macina.room.entities.WorkoutPlan.WorkoutPlanDTO;
import com.macina.room.entities.WorkoutPlan.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/workoutDayExercise")
public class WorkoutDayExerciseController extends GenericController<WorkoutDayExerciseDTO> {

    @Autowired
    private WorkoutPlanService workoutPlanService;
    public WorkoutDayExerciseController(WorkoutDayExerciseService service) {
        super(service);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto<Page<WorkoutPlanDTO>>> addExercise(
            Pageable pageable, @RequestBody AddExercisesDTO addExercisesDTO
    ){
        Page<WorkoutPlanDTO> dtos = workoutPlanService.addExercise(pageable, addExercisesDTO);
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Exercise added successfully", dtos));
    }

}
