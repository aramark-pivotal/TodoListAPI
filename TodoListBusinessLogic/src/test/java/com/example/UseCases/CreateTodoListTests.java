package com.example.UseCases;

import Fakes.FakeTodoListRepository;
import Spies.CreateTodoListObserverSpy;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class CreateTodoListTests {

    private TodoListRepository repo = new FakeTodoListRepository();
    private CreateTodoList createTodoList = new CreateTodoList(repo);

    private CreateTodoListObserverSpy observer = new CreateTodoListObserverSpy();

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
    public void createTodoList_withValidName_notifiesTheObserverWithTheTodoList() throws Exception {
        createTodoList.execute("A Valid Name", observer);

        assertThat(observer.createdTodoList.getName(), equalTo("A Valid Name"));
        assertNotNull(observer.createdTodoList.getId());
    }

    @Test
    public void createTodoList_withEmptyName_notifiesTheObserverWithError() throws Exception {
        createTodoList.execute("", observer);

        assertTrue(observer.invalidTodoListWasCalled);
    }
}
