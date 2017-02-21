package com.example.Adapters;

import com.example.Entities.TodoListEntity;
import com.example.JpaRepositories.TodoListJpaRepository;
import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TodoListRepositoryAdapter implements TodoListRepository {

    private final TodoListJpaRepository todoListJpaRepository;

    public TodoListRepositoryAdapter(TodoListJpaRepository todoListJpaRepository) {
        this.todoListJpaRepository = todoListJpaRepository;
    }

    public void save(TodoList todoList) {
        TodoListEntity entity = entityFromModel(todoList);
        todoList.setId(entity.getId());
        todoListJpaRepository.save(entity);
    }

    public List<TodoList> fetchAll() {
        return todoListJpaRepository.findAll().stream()
                .map(todoListEntity -> modelFromEntity(todoListEntity))
                .collect(Collectors.toList());
    }

    public void deleteAll() {
        todoListJpaRepository.findAll().forEach(todoListEntity -> todoListJpaRepository.delete(todoListEntity));
    }

    TodoListEntity entityFromModel(TodoList todoList) {
        TodoListEntity entity = new TodoListEntity();
        entity.setId(UUID.randomUUID());
        entity.setName(todoList.getName());
        return entity;
    }

    TodoList modelFromEntity(TodoListEntity entity) {
        TodoList model = new TodoList(entity.getName());
        model.setId(entity.getId());
        return model;
    }
}
