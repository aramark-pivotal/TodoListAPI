package com.example.Observers;

import com.example.Models.TodoList;
import com.example.ObserverInterfaces.CreateTodoListObserver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

public class CreateTodoListObserverImpl implements CreateTodoListObserver {
    private DeferredResult<ResponseEntity> result;

    public CreateTodoListObserverImpl(DeferredResult<ResponseEntity> result) {
        this.result = result;
    }

    public void successfullyCreated(TodoList todoList) {
        result.setResult(ResponseEntity.ok().body(todoList));
    }

    public void invalidTodoList() {
        result.setResult(ResponseEntity.badRequest().body("error"));
    }
}
