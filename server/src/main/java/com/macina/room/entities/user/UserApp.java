package com.macina.room.entities.user;

import com.macina.room.crud.BaseEntity;
import com.macina.room.entities.WorkoutPlan.WorkoutPlan;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Comment;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter
@Comment("Utente dell app. Può creare uno o più piani di allenamento.")
public class UserApp extends BaseEntity {

    private String username;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<WorkoutPlan> workoutPlans;

    public UserApp(String username, String email) {
        this.username = username;
        this.email = email;
    }
}