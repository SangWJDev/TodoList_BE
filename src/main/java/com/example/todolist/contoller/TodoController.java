package com.example.todolist.contoller;

import com.example.todolist.dto.TodoRequestDto;
import com.example.todolist.dto.TodoResponseDto;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  @PostMapping
  public ResponseEntity<TodoResponseDto> create(TodoRequestDto todoRequestDto) {
    return ResponseEntity.ok(TodoResponseDto.toDto(
        todoService.create(TodoRequestDto.toEntity(todoRequestDto))));
  }

  @GetMapping("/{id}")
  public ResponseEntity<TodoResponseDto> read(@PathVariable Long id) {
    return ResponseEntity.ok(TodoResponseDto.toDto(todoService.read(id)));
  }




}
