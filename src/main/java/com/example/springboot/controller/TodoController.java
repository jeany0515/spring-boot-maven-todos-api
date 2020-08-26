package com.example.springboot.controller;

import com.example.springboot.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    public List<Todo> todoList;

    public TodoController() {
        this.todoList = getTodos();
    }

    public List<Todo> getTodos() {
        List<Todo> todoList = new ArrayList<>();
        Todo todo0 = new Todo();
        todo0.setId(0);
        todo0.setDone(false);
        todo0.setText("this is my first todo");
        todoList.add(todo0);

        Todo todo1 = new Todo();
        todo1.setId(1);
        todo1.setDone(false);
        todo1.setText("this is my second todo");
        todoList.add(todo1);

        return todoList;
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoList;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        todo.setId(todoList.size());
        todoList.add(todo);

        return todo;
    }

    @PutMapping("/{todoId}")
    public Todo update(@PathVariable Integer todoId, @RequestBody Todo newTodo) {
        Todo oldTodo = todoList.stream().filter(todo -> todoId.equals(todo.getId())).findFirst().get();
        int index = todoList.indexOf(oldTodo);
        todoList.set(index, newTodo);

        return newTodo;
    }
}
