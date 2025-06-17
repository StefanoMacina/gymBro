package com.macina.room.entities.workoutDayExercise;

import com.macina.room.crud.GenericServiceImpl;
import com.macina.room.entities.exercise.Exercise;
import com.macina.room.entities.exercise.ExerciseRepository;
import com.macina.room.entities.workoutDay.WorkoutDay;
import com.macina.room.entities.workoutDay.WorkoutDayRepository;
import jakarta.transaction.Transactional;
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

    @Override
    @Transactional
    public WorkoutDayExerciseDTO update(Long id, WorkoutDayExerciseDTO dto) {
        WorkoutDayExercise entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));

        // Se è stato passato un nuovo esercizio
        if (dto.getExercise() != null) {
            Exercise exercise = exerciseRepository.findById(dto.getExercise().getId())
                    .orElseThrow(() -> new RuntimeException("Exercise not found with id: " + dto.getExercise()));
            entity.setExercise(exercise);
        }

        // Aggiorna gli altri campi
        if (dto.getSets() != null)
            entity.setSets(dto.getSets());
        if (dto.getReps() != null)
            entity.setReps(dto.getReps());
        if (dto.getNotes() != null)
            entity.setNotes(dto.getNotes());
        if (dto.getSequence() != null)
            entity.setSequence(dto.getSequence());


        repository.save(entity);
        return mapper.toDto(entity);
    }



}
