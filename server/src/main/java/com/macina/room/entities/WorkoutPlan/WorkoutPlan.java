package com.macina.room.entities.WorkoutPlan;

import com.macina.room.crud.BaseEntity;
import com.macina.room.entities.workoutDay.WorkoutDay;
import com.macina.room.entities.user.UserApp;
import com.macina.room.interfaces.Nameable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Comment("Scheda di allenamento dell utente. Contiene i giorni e gli esercizi.")
public class WorkoutPlan extends BaseEntity implements Nameable {

    private String name;

    @ManyToOne
    private UserApp user;

    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL)
    private List<WorkoutDay> days;

}
