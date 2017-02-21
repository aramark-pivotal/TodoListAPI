package com.example.UseCases;

import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;

import java.util.List;

public class FetchAllTodoLists {
    private final TodoListRepository todoListRepository;

    public FetchAllTodoLists(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public List<TodoList> execute() {
        return todoListRepository.fetchAll();
    }

    public static List<TodoList> fetchAllTodoLists(TodoListRepository todoListRepository) {
        return new FetchAllTodoLists(todoListRepository).execute();
    }

}
