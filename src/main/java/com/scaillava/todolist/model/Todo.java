package com.scaillava.todolist.model;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private byte[] document;

//    @OneToMany(mappedBy = "list")
//    private java.util.List<com.scaillava.todolist.model.Item> items;
    private String description;

    public Todo(String title, byte[] document, String description) {
        this.title = title;
        this.document = document;
        this.description = description;
        this.done = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    private boolean done;

    public Todo() {
    }


}
