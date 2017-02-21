package Support;

import Fakes.FakeTodoListRepository;
import Repositories.Contracts.TodoListRepositoryTests;
import com.example.Repositories.Interfaces.TodoListRepository;

public class FakeTodoListListRepositoryTests extends TodoListRepositoryTests {

    @Override
    protected TodoListRepository createRepo() {
        return new FakeTodoListRepository();
    }

}
