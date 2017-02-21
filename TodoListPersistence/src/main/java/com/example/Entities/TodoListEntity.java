package com.example.Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="todolists")
public class TodoListEntity {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private String name;

    @Id
    @GeneratedValue
    private UUID id;
}
