package com.example.Controllers;

import com.example.Exceptions.InvalidTodoListException;
import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

import static com.example.UseCases.CreateTodoList.createTodoList;
import static com.example.UseCases.FetchAllTodoLists.fetchAllTodoLists;

@RestController("/todoLists")
public class TodoListController {

    @Autowired
    private TodoListRepository todoListRepo;

    @PostMapping
    public ResponseEntity<TodoList> createNewTodoList(@RequestParam(value = "name") String name) throws InvalidTodoListException {
        return ResponseEntity.ok(createTodoList(name, todoListRepo));
    }

    @GetMapping
    public ResponseEntity<List<TodoList>> fetchAll() {
        return ResponseEntity.ok(fetchAllTodoLists(todoListRepo));
    }

}
