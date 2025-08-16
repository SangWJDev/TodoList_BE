package com.example.todolist.dto;


import com.example.todolist.domain.Todo;
import com.example.todolist.domain.enumerate.TodoCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoRequestDto {

  private String description;

  private boolean completed;

  private TodoCategory category;

  public static Todo toEntity(TodoRequestDto todoDto) {
    return Todo.builder().description(todoDto.getDescription()).completed(todoDto.isCompleted())
        .category(todoDto.getCategory()).build();
  }

}
