package com.example.todolist.service;

import com.example.todolist.domain.Todo;

public interface TodoService {

  void create(Todo todo);

  Todo read(Long todoId);

  void delete(Long todoId);

  Todo update(Long todoId);


}
