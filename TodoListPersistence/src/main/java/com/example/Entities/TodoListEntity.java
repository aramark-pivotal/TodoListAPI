package com.example.Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="todo_lists")
public class TodoListEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

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

}
