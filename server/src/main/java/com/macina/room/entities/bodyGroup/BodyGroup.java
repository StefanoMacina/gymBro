package com.macina.room.entities.bodyGroup;

import com.macina.room.crud.BaseEntity;
import com.macina.room.interfaces.Nameable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Comment("Gruppo muscolare. Usato per classificare gli esercizi.")

public class BodyGroup  extends BaseEntity implements Nameable {

    //@Enumerated(EnumType.STRING)
    private String name;

    private String description;

}
