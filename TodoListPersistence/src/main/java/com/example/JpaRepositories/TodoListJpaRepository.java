package com.example.JpaRepositories;

import com.example.Entities.TodoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoListJpaRepository extends JpaRepository<TodoListEntity, UUID> {
}
