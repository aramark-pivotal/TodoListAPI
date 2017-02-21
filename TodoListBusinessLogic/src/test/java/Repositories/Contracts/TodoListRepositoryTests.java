package Repositories.Contracts;

import com.example.Models.TodoList;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public abstract class TodoListRepositoryTests {
    protected TodoListRepository repo;

    protected abstract TodoListRepository createRepo();

    @Before
    public void before() {
        repo = createRepo();
    }

    @Test
    public void save_createsUniqueIds() {
        TodoList todoList1 = new TodoList("Todo List 1");
        TodoList todoList2 = new TodoList("Todo List 2");

        assertNull(todoList1.getId());
        assertNull(todoList2.getId());

        repo.save(todoList1);
        repo.save(todoList2);

        assertNotNull(todoList1.getId());
        assertNotNull(todoList2.getId());

        assertNotEquals(todoList1.getId(), todoList2.getId());
    }

    @Test
    public void fetchAll_whenThereAreSavedTodoLists_returnsAListOfTodoLists() {
        TodoList todoList1 = new TodoList("Todo List 1");
        TodoList todoList2 = new TodoList("Todo List 2");

        repo.save(todoList1);
        repo.save(todoList2);

        List<TodoList> todoLists = repo.fetchAll();

        assertThat(todoLists, equalTo(Arrays.asList(todoList1, todoList2)));
    }

    @Test
    public void deleteAll_removesAllTodoLists() {
        TodoList todoList = new TodoList("Todo List");

        repo.save(todoList);

        List<TodoList> todoLists = repo.fetchAll();

        assertThat(todoLists.size(), equalTo(1));

        repo.deleteAll();;

        todoLists = repo.fetchAll();

        assertThat(todoLists.size(), equalTo(0));
    }

}
