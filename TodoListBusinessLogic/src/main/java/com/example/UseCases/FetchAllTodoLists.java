package com.example.UseCases;

import com.example.Models.TodoList;
import com.example.ObserverInterfaces.FetchAllTodoListsObserver;
import com.example.Repositories.Interfaces.TodoListRepository;

import java.util.List;

public class FetchAllTodoLists {
    private final TodoListRepository todoListRepository;
    private final FetchAllTodoListsObserver observer;

    public FetchAllTodoLists(FetchAllTodoListsObserver observer, TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
        this.observer = observer;
    }

    public void execute() {
        List<TodoList> todoLists = todoListRepository.fetchAll();
        if (todoLists.size() > 0) {
            observer.fetchedResults(todoLists);
        } else {
            observer.emptyResults();
        }
    }

    public static void fetchAllTodoLists(FetchAllTodoListsObserver observer, TodoListRepository todoListRepository) {
        new FetchAllTodoLists(observer, todoListRepository).execute();
    }


}
