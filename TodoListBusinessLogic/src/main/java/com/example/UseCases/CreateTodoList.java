package com.example.UseCases;

import com.example.Models.TodoList;
import com.example.ObserverInterfaces.CreateTodoListObserver;
import com.example.Repositories.Interfaces.TodoListRepository;

public class CreateTodoList {
    private final String name;
    private final TodoListRepository repo;
    private final CreateTodoListObserver observer;

    public CreateTodoList(String name, CreateTodoListObserver observer, TodoListRepository repo) {
        this.name = name;
        this.repo = repo;
        this.observer = observer;
    }

    public void execute() {
        if ("".equals(name)) {
            observer.invalidTodoList();
            return;
        }
        TodoList todoList = new TodoList(name);
        repo.save(todoList);
        observer.successfullyCreated(todoList);
    }

    public static void createTodoList(String name, CreateTodoListObserver observer, TodoListRepository repo) {
        new CreateTodoList(name, observer, repo).execute();
    }

}
