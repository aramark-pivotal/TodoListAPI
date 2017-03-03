package com.example.Controllers;

import com.example.Observers.CreateTodoListObserverImpl;
import com.example.Observers.FetchAllTodoListsObserverImpl;
import com.example.UseCases.CreateTodoList;
import com.example.UseCases.FetchAllTodoLists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController("/todoLists")
public class TodoListController {

    @Autowired
    private CreateTodoList createTodoList;

    @Autowired
    private FetchAllTodoLists fetchAllTodoLists;

    @PostMapping
    public DeferredResult<ResponseEntity> createNewTodoList(@RequestParam(value = "name") String name) {
        DeferredResult<ResponseEntity> response = new DeferredResult<>();
        createTodoList.execute(name, new CreateTodoListObserverImpl(response));
        return response;
    }

    @GetMapping
    public DeferredResult<ResponseEntity> fetchAll() {
        DeferredResult<ResponseEntity> response = new DeferredResult<>();
        fetchAllTodoLists.execute(new FetchAllTodoListsObserverImpl(response));
        return response;
    }
}
