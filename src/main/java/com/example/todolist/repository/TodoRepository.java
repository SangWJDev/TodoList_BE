package com.example.todolist.repository;

import com.example.todolist.domain.Todo;
import com.example.todolist.domain.enumerate.TodoCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findByCategoryIn(List<TodoCategory> categories);

}
