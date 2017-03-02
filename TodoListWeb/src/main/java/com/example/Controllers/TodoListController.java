package com.example.Controllers;

import com.example.Observers.CreateTodoListObserverImpl;
import com.example.Observers.FetchAllTodoListsObserverImpl;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import static com.example.UseCases.CreateTodoList.createTodoList;
import static com.example.UseCases.FetchAllTodoLists.fetchAllTodoLists;

@RestController("/todoLists")
public class TodoListController {

    @Autowired
    private TodoListRepository todoListRepo;

    @PostMapping
    public DeferredResult<ResponseEntity> createNewTodoList(@RequestParam(value = "name") String name) {
        DeferredResult<ResponseEntity> response = new DeferredResult<>();
        createTodoList(name, new CreateTodoListObserverImpl(response), todoListRepo);
        return response;
    }

    @GetMapping
    public DeferredResult<ResponseEntity> fetchAll() {
        DeferredResult<ResponseEntity> response = new DeferredResult<>();
        fetchAllTodoLists(new FetchAllTodoListsObserverImpl(response), todoListRepo);
        return response;
    }
}
