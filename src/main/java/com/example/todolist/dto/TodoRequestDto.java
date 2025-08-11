package com.example.todolist.dto;


import com.example.todolist.domain.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoRequestDto {

  private String description;

  private boolean completed;

  public static Todo toEntity(TodoRequestDto todoDto) {
    return Todo.builder().description(todoDto.getDescription()).completed(todoDto.isCompleted()).build();
  }

}
