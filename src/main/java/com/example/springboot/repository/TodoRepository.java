package com.example.springboot.repository;

import com.example.springboot.model.Todo;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    @PostConstruct
    private void addTodos() {
        todos.add(new Todo(0, "this is the first action", false));
        todos.add(new Todo(1, "this is the second action", false));
        todos.add(new Todo(2, "this is the third action", true));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo add(Todo todo) {
        todos.add(todo);
        return todo;
    }

    public Todo findById(Integer todoId) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(todoId))
                .findFirst()
                .orElse(null);
    }
}