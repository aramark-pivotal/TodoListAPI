package com.example;

import com.example.Repositories.InMemoryTodoListRepository;
import com.example.Repositories.Interfaces.TodoListRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoListWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListWebApplication.class, args);
	}

	@Bean
	public TodoListRepository todoListRepository() {
		return new InMemoryTodoListRepository();
	}

}
