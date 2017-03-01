package com.example;

import com.example.JpaRepositories.TodoListJpaRepository;
import com.example.Repositories.Interfaces.TodoListRepository;
import com.example.Adapters.TodoListRepositoryAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TodoListWebApplication {


	public static void main(String[] args) {
		SpringApplication.run(TodoListWebApplication.class, args);
	}

	@Bean
	public TodoListRepository todoListRepository(TodoListJpaRepository todoListJpaRepository) {
		return new TodoListRepositoryAdapter(todoListJpaRepository);
	}

}
