package com.scaillava.todolist.service;

import com.scaillava.todolist.domain.TodoPOJO;
import com.scaillava.todolist.exception.TodoRequired;
import com.scaillava.todolist.model.Todo;

public interface TodoService {

    public void saveTodo(Todo todo) throws TodoRequired;

    public Iterable<Todo> getTodos(String id, String description, String done);

    public void deleteTodo(String id) throws TodoRequired;

}
