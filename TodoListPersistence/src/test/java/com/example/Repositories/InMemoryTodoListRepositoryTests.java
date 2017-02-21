package com.example.Repositories;

import Repositories.Contracts.TodoListRepositoryTests;
import com.example.Adapters.InMemoryTodoListRepository;
import com.example.Repositories.Interfaces.TodoListRepository;

public class InMemoryTodoListRepositoryTests extends TodoListRepositoryTests {

    @Override
    protected TodoListRepository createRepo() { return new InMemoryTodoListRepository(); }

}
