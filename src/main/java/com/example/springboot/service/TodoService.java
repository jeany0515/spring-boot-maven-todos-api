package com.example.springboot.service;

import com.example.springboot.model.Todo;
import com.example.springboot.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        return todoRepository.add(todo);
    }

    public Todo update(Integer todoId, Todo todoUpdate) {
        Todo todo = todoRepository.findById(todoId);
        if (todoUpdate.getText() != null) {
            todo.setText(todoUpdate.getText());
        }
        if (todoUpdate.getDone() != null) {
            todo.setDone(todoUpdate.getDone());
        }
        return todo;
    }

}