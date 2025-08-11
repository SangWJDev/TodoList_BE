package com.example.todolist.dto;


import com.example.todolist.domain.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoDto {

  private String description;

  private boolean completed;

  public static Todo toEntity(TodoDto todoDto) {
    return Todo.builder().description(todoDto.description).completed(todoDto.completed).build();
  }

}
