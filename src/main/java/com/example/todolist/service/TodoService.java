package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import java.util.List;

public interface TodoService {

  Todo create(Todo todo);

  Todo read(Long todoId);

  void delete(Long todoId);

  Todo update(Long todoId, String description);

  void updateComplete(Long todoId);

  List<Todo> readAll();


}
