package com.example.UseCases;

import Fakes.FakeTodoListRepository;
import Spies.FetchAllTodoListsObserverSpy;
import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.example.UseCases.FetchAllTodoLists.fetchAllTodoLists;
import static org.junit.Assert.*;

public class FetchAllTodoListsTests {

    private TodoListRepository repo = new FakeTodoListRepository();
    private FetchAllTodoListsObserverSpy observer = new FetchAllTodoListsObserverSpy();

    @Before
    public void before() {
        observer.reset();
        repo.deleteAll();
    }

    @After
    public void after() {
        observer.reset();
        repo.deleteAll();
    }

    @Test
    public void fetchAllTodoLists_whenThereAreNoSavedTodoLists_notifiesTheObserverOfEmptyResults() {
        fetchAllTodoLists(observer, repo);

        assertTrue(observer.emptyResultsWasCalled);
    }

    @Test
    public void fetchAllTodoLists_whenThereAreSavedTodoLists_notifiesTheObserverWithTheResults() {
        TodoList todoList1 = new TodoList("Todo List 1");
        TodoList todoList2 = new TodoList("Todo List 2");

        repo.save(todoList1);
        repo.save(todoList2);

        fetchAllTodoLists(observer, repo);

        assertEquals(observer.fetchedTodoLists, Arrays.asList(todoList1, todoList2));
    }

}
