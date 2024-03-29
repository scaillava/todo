package com.scaillava.todolist.exception;

public class TodoRequired extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;

    public TodoRequired(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
