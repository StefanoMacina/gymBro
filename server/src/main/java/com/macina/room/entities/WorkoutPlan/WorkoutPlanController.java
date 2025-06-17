package com.macina.room.entities.WorkoutPlan;

import com.macina.room.DTO.AddExercisesDTO;
import com.macina.room.DTO.ResponseDto;
import com.macina.room.DTO.IDRequest;
import com.macina.room.controller.GenericNameableController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/workoutPlan")
public class WorkoutPlanController extends GenericNameableController<WorkoutPlanDTO> {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    public WorkoutPlanController(WorkoutPlanService service) {
        super(service);
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseDto<Page<WorkoutPlanDTO>>> getAllByUser(
            Pageable pageable, @RequestBody IDRequest IDRequest
            ){
        Page<WorkoutPlanDTO> dtos = workoutPlanService.findAllByUserID(pageable, IDRequest.getId());
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entities retrieved successfully", dtos));
    }


}