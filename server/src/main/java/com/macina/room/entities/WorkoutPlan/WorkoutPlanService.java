package com.macina.room.entities.WorkoutPlan;

import com.macina.room.DTO.AddExercisesDTO;
import com.macina.room.DTO.ExerciseMapDTO;
import com.macina.room.entities.exercise.Exercise;
import com.macina.room.entities.exercise.ExerciseRepository;
import com.macina.room.entities.user.UserApp;
import com.macina.room.entities.user.UserRepository;
import com.macina.room.entities.workoutDay.WorkoutDay;
import com.macina.room.entities.workoutDay.WorkoutDayRepository;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExercise;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExerciseRepository;
import com.macina.room.service.NameableServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutPlanService extends NameableServiceImpl<WorkoutPlanDTO, WorkoutPlan> {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutDayRepository workoutDayRepository;
    @Autowired
    private WorkoutDayExerciseRepository workoutDayExerciseRepository;

    public WorkoutPlanService(WorkoutPlanRepository repository, WorkoutPlanMapper mapper) {
        super(repository, mapper);
    }

    public Page<WorkoutPlanDTO> findAllByUserID(Pageable pageable, Long id){
        return workoutPlanRepository.findAllByUser_Id(pageable,id).map(
                mapper::toDto
        );
    }

    @Override
    @Transactional
    public WorkoutPlanDTO create(WorkoutPlanDTO dto) {
        WorkoutPlan entity = mapper.toEntity(dto);

        UserApp user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));
        entity.setUser(user);

        entity = workoutPlanRepository.save(entity);
        return mapper.toDto(entity);
    }


    @Transactional
    public Page<WorkoutPlanDTO> addExercise(Pageable pageable, AddExercisesDTO addExercisesDTO){
        long workoutDayID = addExercisesDTO.getWorkoutDay();
        WorkoutDay existingWorkOutDay = workoutDayRepository.findById(workoutDayID)
                .orElseThrow(() -> new RuntimeException("workout day with id: " + workoutDayID));

        for(ExerciseMapDTO ex : addExercisesDTO.getExercises()){
            Exercise existingEx = exerciseRepository.findById(ex.getExerciseId()).orElseThrow(() -> new RuntimeException("exercise with id: " + workoutDayID));

            WorkoutDayExercise newWDay = new WorkoutDayExercise(
                ex.getSets(),ex.getReps(),ex.getNote(),existingWorkOutDay,existingEx,ex.getSequence()
            );
            workoutDayExerciseRepository.save(newWDay);
        }
        return null;
    }


}