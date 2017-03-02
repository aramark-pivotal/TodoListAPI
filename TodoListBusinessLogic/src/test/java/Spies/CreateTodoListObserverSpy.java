package Spies;

import com.example.Models.TodoList;
import com.example.ObserverInterfaces.CreateTodoListObserver;

public class CreateTodoListObserverSpy implements CreateTodoListObserver {
    public TodoList createdTodoList;
    public boolean invalidTodoListWasCalled = false;

    public void successfullyCreated(TodoList todoList) {
        createdTodoList = todoList;
    }

    public void invalidTodoList() {
        invalidTodoListWasCalled = true;
    }

    public void reset() {
        createdTodoList = null;
        invalidTodoListWasCalled = false;
    }
}
