package com.macina.room.entities.workoutDayExercise;

import com.macina.room.crud.BaseEntity;
import com.macina.room.entities.workoutDay.WorkoutDay;
import com.macina.room.entities.exercise.Exercise;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
@Comment("Un esercizio svolto in un certo giorno. Contiene set, ripetizioni e note.")
public class WorkoutDayExercise extends BaseEntity {

    private int sets;

    private int reps;

    private String notes;

    @ManyToOne
    private WorkoutDay workoutDay;

    @ManyToOne
    private Exercise exercise;

    private short sequence;
}