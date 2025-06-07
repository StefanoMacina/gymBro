package com.macina.room.entities.workoutDay;

import com.macina.room.crud.BaseEntity;
import com.macina.room.entities.WorkoutPlan.WorkoutPlan;
import com.macina.room.entities.workoutDayExercise.WorkoutDayExercise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Comment("Un esercizio svolto in un certo giorno. Contiene set, ripetizioni e note.")
public class WorkoutDay extends BaseEntity {

    private short sequence;

    @ManyToOne
    private WorkoutPlan workoutPlan;

    @OneToMany(mappedBy = "workoutDay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutDayExercise> exercises;

    public WorkoutDay(short sequence, WorkoutPlan workoutPlan) {
        this.sequence = sequence;
        this.workoutPlan = workoutPlan;
    }
}