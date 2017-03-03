package com.example.UseCases;

import com.example.Models.TodoList;
import com.example.ObserverInterfaces.CreateTodoListObserver;
import com.example.Repositories.Interfaces.TodoListRepository;

public class CreateTodoList {
    private final TodoListRepository repo;

    public CreateTodoList(TodoListRepository repo) {
        this.repo = repo;
    }

    public void execute(String name, CreateTodoListObserver observer) {
        if ("".equals(name)) {
            observer.invalidTodoList();
            return;
        }
        TodoList todoList = new TodoList(name);
        repo.save(todoList);
        observer.successfullyCreated(todoList);
    }
}
