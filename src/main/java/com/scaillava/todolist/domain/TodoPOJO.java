package com.scaillava.todolist.domain;

public class TodoPOJO {

    private String description;
    private byte[] document;
    private String title;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    private boolean done;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public TodoPOJO() {
    }

    public TodoPOJO(String description) {
        this.description = description;
    }




}

