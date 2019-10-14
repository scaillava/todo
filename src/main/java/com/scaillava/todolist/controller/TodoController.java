package com.scaillava.todolist.controller;

import com.scaillava.todolist.domain.TodoPOJO;
import com.scaillava.todolist.model.Todo;
import com.scaillava.todolist.service.TodoService;
import com.weddini.throttling.Throttling;
import com.weddini.throttling.ThrottlingException;
import com.weddini.throttling.ThrottlingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class TodoController {
    private static final Logger log = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todosService;

    //After 100 Request its gonna response 400 bad request
    @Throttling(limit = 100, timeUnit = TimeUnit.SECONDS, type = ThrottlingType.RemoteAddr)
    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public ResponseEntity saveTodo(@RequestBody Todo todo) {
        try {
            todosService.saveTodo(todo);

            return ResponseEntity
                    .status(HttpStatus.OK).body(null);


        } catch (ThrottlingException ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(ex.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }


    //After 100 Request its gonna response 400 bad request
    @Throttling(limit = 100, timeUnit = TimeUnit.SECONDS, type = ThrottlingType.RemoteAddr)
    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public ResponseEntity getTodos(@RequestParam(required = false) String id, @RequestParam(required = false) String description, @RequestParam(required = false) String done) {
        try {
            Iterable<Todo> todos = todosService.getTodos(id, description, done);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(todos);

        } catch (ThrottlingException ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(ex.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }

    //After 100 Request its gonna response 400 bad request
    @Throttling(limit = 100, timeUnit = TimeUnit.SECONDS, type = ThrottlingType.RemoteAddr)
    @RequestMapping(value = "/todo", method = RequestMethod.PUT)
    public ResponseEntity updateTodo(@RequestBody Todo todo) {
        try {
            todosService.saveTodo(todo);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(null);

        } catch (ThrottlingException ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(ex.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
