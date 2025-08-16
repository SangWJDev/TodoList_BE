package com.example.todolist.service;


import com.example.todolist.domain.Todo;
import com.example.todolist.domain.enumerate.TodoCategory;
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
  public Todo update(Long todoId, String description, TodoCategory category) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("todo가 없습니다."));
    todo.updateTodo(description, category);
    return todo;
  }

  @Override
  @Transactional
  public Todo updateComplete(Long todoId) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("todo가 없습니다."));
    todo.updateCompleted();
    return todo;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Todo> readAll() {
    return todoRepository.findAll();
  }
}
