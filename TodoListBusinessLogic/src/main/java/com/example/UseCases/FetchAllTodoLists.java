package com.example.UseCases;

import com.example.Models.TodoList;
import com.example.ObserverInterfaces.FetchAllTodoListsObserver;
import com.example.Repositories.Interfaces.TodoListRepository;

import java.util.List;

public class FetchAllTodoLists {
    private final TodoListRepository todoListRepository;

    public FetchAllTodoLists(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void execute(FetchAllTodoListsObserver observer) {
        List<TodoList> todoLists = todoListRepository.fetchAll();
        if (todoLists.size() > 0) {
            observer.fetchedResults(todoLists);
        } else {
            observer.emptyResults();
        }
    }

}
