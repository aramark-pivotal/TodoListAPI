package com.example.Repositories;

import Repositories.Contracts.TodoListRepositoryTests;
import com.example.Adapters.TodoListRepositoryAdapter;
import com.example.JpaRepositories.TodoListJpaRepository;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoListRepositoryAdapterTests extends TodoListRepositoryTests {

    @Autowired
    private TodoListJpaRepository todoListJpaRepository;

    @Override
    protected TodoListRepository createRepo() { return new TodoListRepositoryAdapter(todoListJpaRepository); }

}
