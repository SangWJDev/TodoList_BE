package com.example.todolist.service;

import com.example.todolist.domain.Todo;

public interface TodoService {

  Todo create(Todo todo);

  Todo read(Long todoId);

  void delete(Long todoId);

  void update(Long todoId, String description);

  void updateComplete(Long todoId);


}
