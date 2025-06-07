package com.macina.room.entities.workoutDayExercise;

import com.macina.room.crud.GenericServiceImpl;
import com.macina.room.entities.exercise.Exercise;
import com.macina.room.entities.exercise.ExerciseRepository;
import com.macina.room.entities.workoutDay.WorkoutDay;
import com.macina.room.entities.workoutDay.WorkoutDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WorkoutDayExerciseService extends GenericServiceImpl<WorkoutDayExerciseDTO, WorkoutDayExercise> {


    @Autowired
    private WorkoutDayRepository workoutDayRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutDayExerciseRepository repository;
    public WorkoutDayExerciseService(WorkoutDayExerciseRepository repository, WorkoutDayExerciseMapper mapper) {
        super(repository, mapper);
    }


    @Override
    public WorkoutDayExerciseDTO create(WorkoutDayExerciseDTO dto) {
            WorkoutDayExercise entity = mapper.toEntity(dto);

            WorkoutDay workoutDay = workoutDayRepository.findById(dto.getWorkoutDayId())
                    .orElseThrow(() -> new RuntimeException("WorkoutDay not found"));

            Exercise exercise = exerciseRepository.findById(dto.getExercise().getId())
                    .orElseThrow(() -> new RuntimeException("Exercise not found"));

            entity.setWorkoutDay(workoutDay);
            entity.setExercise(exercise);

            entity = repository.save(entity);
            return mapper.toDto(entity);
    }
}
