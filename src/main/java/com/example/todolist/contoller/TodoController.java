package com.example.todolist.contoller;

import com.example.todolist.dto.TodoRequestDto;
import com.example.todolist.dto.TodoResponseDto;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  @PostMapping
  public ResponseEntity<TodoResponseDto> create(TodoRequestDto todoRequestDto) {
    return ResponseEntity.ok(TodoResponseDto.toDto(
        todoService.create(TodoRequestDto.toEntity(todoRequestDto))));
  }


}
