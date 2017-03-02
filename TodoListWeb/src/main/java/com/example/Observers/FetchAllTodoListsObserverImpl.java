package com.example.Observers;

import com.example.Models.TodoList;
import com.example.ObserverInterfaces.FetchAllTodoListsObserver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collections;
import java.util.List;

public class FetchAllTodoListsObserverImpl implements FetchAllTodoListsObserver {
    private final DeferredResult<ResponseEntity> response;

    public FetchAllTodoListsObserverImpl(DeferredResult<ResponseEntity> response) {
        this.response = response;
    }

    public void emptyResults() {
        response.setResult(ResponseEntity.ok().body(Collections.emptyList()));
    }

    public void fetchedResults(List<TodoList> todoLists) {
        response.setResult(ResponseEntity.ok().body(todoLists));
    }
}
