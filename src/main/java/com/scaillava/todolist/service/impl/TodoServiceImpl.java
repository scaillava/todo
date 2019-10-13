package com.scaillava.todolist.service.impl;

import com.scaillava.todolist.config.PropertiesUtil;
import com.scaillava.todolist.exception.TodoRequired;
import com.scaillava.todolist.model.Todo;
import com.scaillava.todolist.repository.TodoRepository;
import com.scaillava.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class
TodoServiceImpl implements TodoService {
    @Autowired
    PropertiesUtil propertiesUtil;
    @Autowired
    TodoRepository todoRepository;


    @Override
    public void saveTodo(Todo todo) throws TodoRequired {
        try {
            todoRepository.save(todo);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Iterable<Todo> getTodos(String id, String description, String done) {
        try {
            return todoRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteTodo(String id) throws TodoRequired {
        try {
            todoRepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
    }


}
