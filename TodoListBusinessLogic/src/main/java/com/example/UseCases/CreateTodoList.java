package com.example.UseCases;

import com.example.Exceptions.InvalidTodoListException;
import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;

public class CreateTodoList {
    private final String name;
    private final TodoListRepository repo;

    public CreateTodoList(String name, TodoListRepository repo) {
        this.name = name;
        this.repo = repo;
    }

    public TodoList execute() throws InvalidTodoListException {
        if ("".equals(name)) {
            throw new InvalidTodoListException();
        }
        TodoList todoList = new TodoList(name);
        repo.save(todoList);
        return todoList;
    }

    public static TodoList createTodoList(String name, TodoListRepository repo) throws InvalidTodoListException {
        return new CreateTodoList(name, repo).execute();
    }

}
