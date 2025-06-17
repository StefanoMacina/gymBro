package com.macina.room.entities.workoutDay;

import com.macina.room.DTO.ResponseDto;
import com.macina.room.DTO.IDRequest;
import com.macina.room.DTO.UpdateWorkoutDaySequenceDTO;
import com.macina.room.controller.GenericNameableController;
import com.macina.room.crud.GenericController;
import com.macina.room.entities.WorkoutPlan.WorkoutPlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/workoutDay")
public class WorkoutDayController extends GenericNameableController<WorkoutDayDTO> {

    @Autowired
    private WorkoutDayService workoutDayService;
    public WorkoutDayController(WorkoutDayService service) {
        super(service);
    }

    @PostMapping("/createInBatch")
    public ResponseEntity<ResponseDto<List<WorkoutDayDTO>>> createInBatch(
            @RequestBody IDRequest workoutPlan,
            @RequestParam short qty
    ){
        List<WorkoutDayDTO> dtos = workoutDayService.createInBatch(qty,workoutPlan.getId());
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entities retrieved successfully", dtos));
    }

    @PutMapping("/updateSeq")
    public ResponseEntity<ResponseDto<List<WorkoutDayDTO>>> updateSeqInBatch(@RequestBody List<UpdateWorkoutDaySequenceDTO> obj){
        List<WorkoutDayDTO> dtos = workoutDayService.updateSequence(obj);
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entities updated successfully", dtos));
    }

    @PostMapping("/workoutPlan")
    public ResponseEntity<ResponseDto<Page<WorkoutDayDTO>>> getAllByWorkoutPlan(
            Pageable pageable, @RequestBody IDRequest IDRequest
    ){
        Page<WorkoutDayDTO> dtos = workoutDayService.findAllByWorkoutPlanID(pageable, IDRequest.getId());
        return ResponseEntity
                .ok(new ResponseDto<>(true, "Entities retrieved successfully", dtos));
    }
}
