package com.example.todolist.service;


import com.example.todolist.domain.Todo;
import com.example.todolist.repository.TodoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

  private final TodoRepository todoRepository;


  @Override
  @Transactional
  public Todo create(Todo todo) {
    return todoRepository.save(todo);
  }

  @Override
  @Transactional(readOnly = true)
  public Todo read(Long todoId) {
    return todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("todo가 없습니다."));
  }

  @Override
  @Transactional
  public void delete(Long todoId) {
    todoRepository.deleteById(todoId);
  }

  @Override
  @Transactional
  public Todo update(Long todoId, String description) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("todo가 없습니다."));
    todo.updateDescription(description);
    return todo;
  }

  @Override
  @Transactional
  public void updateComplete(Long todoId) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("todo가 없습니다."));
    todo.updateCompleted();
  }

  @Override
  @Transactional(readOnly = true)
  public List<Todo> readAll() {
    return todoRepository.findAll();
  }
}
