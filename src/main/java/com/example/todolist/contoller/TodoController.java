package com.example.todolist.contoller;

import com.example.todolist.dto.TodoRequestDto;
import com.example.todolist.dto.TodoResponseDto;
import com.example.todolist.service.TodoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
  public ResponseEntity<TodoResponseDto> readById(@PathVariable Long id) {
    return ResponseEntity.ok(TodoResponseDto.toDto(todoService.read(id)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    todoService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<TodoResponseDto> update(@PathVariable Long id,
      TodoRequestDto todoRequestDto) {
    return ResponseEntity.ok(
        TodoResponseDto.toDto(todoService.update(id, todoRequestDto.getDescription())));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateComplete(@PathVariable Long id) {
    todoService.updateComplete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<TodoResponseDto>> readAll() {
    List<TodoResponseDto> todoResponseDtoList = todoService.readAll().stream().map(
        TodoResponseDto::toDto).toList();
    return ResponseEntity.ok(todoResponseDtoList);
  }


}
