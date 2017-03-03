package com.example.Adapters;

import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryTodoListRepository implements TodoListRepository {
    private List<TodoList> todoLists = new ArrayList<>();

    public void save(TodoList todoList) {
        todoList.setId(UUID.randomUUID());
        todoLists.add(todoList);
    }

    public List<TodoList> fetchAll() {
        return todoLists;
    }

    public void deleteAll() {
        todoLists = new ArrayList<>();
    }
}
