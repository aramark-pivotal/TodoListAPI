package com.example.UseCases;

import Fakes.FakeTodoListRepository;
import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static com.example.UseCases.FetchAllTodoLists.fetchAllTodoLists;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FetchAllTodoListsTests {

    private TodoListRepository repo = new FakeTodoListRepository();

    @Before
    public void before() {
        repo.deleteAll();
    }

    @After
    public void after() {
        repo.deleteAll();
    }

    @Test
    public void fetchAllTodoLists_whenThereAreNoSavedTodoLists_returnsAnEmptyList() {
        List<TodoList> todoLists = fetchAllTodoLists(repo);

        List<TodoList> emptyList = Collections.emptyList();
        assertThat(todoLists, equalTo(emptyList));
    }

    @Test
    public void fetchAllTodoLists_whenThereAreSavedTodoLists_returnsAListOfTheTodoLists() {
        TodoList todoList1 = new TodoList("Todo List 1");
        TodoList todoList2 = new TodoList("Todo List 2");

        repo.save(todoList1);
        repo.save(todoList2);

        List<TodoList> todoLists = fetchAllTodoLists(repo);

        assertThat(todoLists, equalTo(Arrays.asList(todoList1, todoList2)));
    }

}
