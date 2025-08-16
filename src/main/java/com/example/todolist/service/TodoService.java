package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.domain.enumerate.TodoCategory;
import java.util.List;

public interface TodoService {

  Todo create(Todo todo);

  Todo read(Long todoId);

  void delete(Long todoId);

  Todo update(Long todoId, String description, TodoCategory category);

  Todo updateComplete(Long todoId);

  List<Todo> readAll();


}
