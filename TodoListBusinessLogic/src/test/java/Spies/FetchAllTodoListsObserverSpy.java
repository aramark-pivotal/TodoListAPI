package Spies;

import com.example.Models.TodoList;
import com.example.ObserverInterfaces.FetchAllTodoListsObserver;

import java.util.List;

public class FetchAllTodoListsObserverSpy implements FetchAllTodoListsObserver {
    public boolean emptyResultsWasCalled = false;
    public List<TodoList> fetchedTodoLists;

    public void reset() {
        emptyResultsWasCalled = false;
        fetchedTodoLists = null;
    }

    public void emptyResults() {
        emptyResultsWasCalled = true;
    }

    public void fetchedResults(List<TodoList> todoLists) {
        fetchedTodoLists = todoLists;
    }
}
