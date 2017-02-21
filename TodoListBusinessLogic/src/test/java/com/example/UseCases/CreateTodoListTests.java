package com.example.UseCases;

import Fakes.FakeTodoListRepository;
import com.example.Exceptions.InvalidTodoListException;
import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.example.UseCases.CreateTodoList.createTodoList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CreateTodoListTests {

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
    public void createTodoList_withValidName_returnsTheTodoList() throws Exception {
        TodoList todoList = createTodoList("A Valid Name", repo);

        assertThat(todoList.getName(), equalTo("A Valid Name"));
        assertNotNull(todoList.getId());
    }

    @Test(expected = InvalidTodoListException.class)
    public void createTodoList_withEmptyName_throwsInvalidTodoListException() throws Exception {
        createTodoList("", repo);
    }
}
