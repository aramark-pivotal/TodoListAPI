package com.example.ObserverInterfaces;

import com.example.Models.TodoList;

public interface CreateTodoListObserver {
    void successfullyCreated(TodoList todoList);
    void invalidTodoList();
}
