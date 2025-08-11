package com.example.todolist.service;


import com.example.todolist.domain.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

  private final TodoRepository todoRepository;


  @Override
  public void create(Todo todo) {

  }

  @Override
  public Todo read(Long todoId) {
    return null;
  }

  @Override
  public void delete(Long todoId) {

  }

  @Override
  public Todo update(Long todoId) {
    return null;
  }
}
