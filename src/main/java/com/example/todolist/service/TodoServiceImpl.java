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
  public Todo create(Todo todo) {
    return todoRepository.save(todo);
  }

  @Override
  public Todo read(Long todoId) {
    return todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("todo가 없습니다."));
  }

  @Override
  public void delete(Long todoId) {
    todoRepository.deleteById(todoId);
  }

  @Override
  public void update(Long todoId, String description) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("todo가 없습니다."));
    todo.updateDescription(description);
  }

  @Override
  public void updateComplete(Long todoId) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("todo가 없습니다."));
    todo.updateCompleted();
  }
}
