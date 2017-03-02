package com.example.ObserverInterfaces;

import com.example.Models.TodoList;

import java.util.List;

public interface FetchAllTodoListsObserver {
    void emptyResults();
    void fetchedResults(List<TodoList> todoLists);
}
