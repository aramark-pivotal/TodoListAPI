package Fakes;

import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeTodoListRepository implements TodoListRepository {
    private List<TodoList> todoLists = new ArrayList<TodoList>();

    public void save(TodoList todoList) {
        todoList.setId(UUID.randomUUID());
        todoLists.add(todoList);
    }

    public List<TodoList> fetchAll() {
        return todoLists;
    }

    public void deleteAll() {
        todoLists = new ArrayList<TodoList>();
    }

}
