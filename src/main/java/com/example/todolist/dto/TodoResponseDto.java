package com.example.todolist.dto;


import com.example.todolist.domain.Todo;
import com.example.todolist.domain.enumerate.TodoCategory;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TodoResponseDto {

  private Long id;

  private String description;

  private boolean completed;

  private TodoCategory category;

  private LocalDateTime modified;

  public static TodoResponseDto toDto(Todo todo) {
    return TodoResponseDto.builder().id(todo.getId()).description(todo.getDescription())
        .completed(todo.isCompleted()).category(todo.getCategory()).modified(todo.getUpdatedAt())
        .build();
  }

}
