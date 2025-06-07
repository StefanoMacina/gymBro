package com.macina.room.entities.exercise;

import com.macina.room.crud.BaseEntity;
import com.macina.room.entities.bodyGroup.BodyGroup;
import com.macina.room.interfaces.Nameable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Comment("Esercizio singolo. Può essere inserito da app o creato da utente")
public class Exercise extends BaseEntity implements Nameable {

    private String name;

    private String description;

    @ManyToOne
    private BodyGroup BodyGroup;

    @Override
    public String getName() {
        return name;
    }
}
