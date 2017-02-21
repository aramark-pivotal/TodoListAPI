package com.example.Repositories.Interfaces;

import com.example.Models.TodoList;

import java.util.List;

public interface TodoListRepository {

    void save(TodoList todoList);
    List<TodoList> fetchAll();
    void deleteAll();

}
