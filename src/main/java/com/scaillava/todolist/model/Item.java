//package com.scaillava.todolist.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "item")
//public class Item {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name="list_id")
//    private List list;
//
//    private String description;
//
//    private boolean done;
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public boolean isDone() {
//        return done;
//    }
//
//    public void setDone(boolean done) {
//        this.done = done;
//    }
//}
