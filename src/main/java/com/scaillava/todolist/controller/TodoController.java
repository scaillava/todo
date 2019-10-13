package com.scaillava.todolist.controller;

import com.scaillava.todolist.domain.TodoPOJO;
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
    public ResponseEntity addTodo(@RequestBody TodoPOJO todo) {
        try {
            todosService.addTodo(todo);

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
    public ResponseEntity getTodos(@RequestParam String id, @RequestParam String description, @RequestParam String done) {
        try {
            java.util.List<TodoPOJO> todos = todosService.getTodos(id, description, done);

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
    public ResponseEntity updateTodo(@RequestBody TodoPOJO todo) {
        try {
            todosService.updateTodo(todo);

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


    //After 100 Request its gonna response 400 bad request
    @Throttling(limit = 100, timeUnit = TimeUnit.SECONDS, type = ThrottlingType.RemoteAddr)
    @RequestMapping(value = "/todo", method = RequestMethod.DELETE)
    public ResponseEntity deleteTodo(@RequestParam String id) {
        try {
            todosService.deleteTodo(id);
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
