package com.scaillava.todolist.repository;

import com.scaillava.todolist.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo,String> {

}
