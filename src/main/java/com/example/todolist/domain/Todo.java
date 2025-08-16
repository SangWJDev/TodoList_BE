package com.example.todolist.domain;

import com.example.todolist.domain.enumerate.TodoCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  private boolean completed;

  @Enumerated(value = EnumType.STRING)
  private TodoCategory category;

  @Builder
  public Todo(String description, boolean completed, TodoCategory category) {
    this.description = description;
    this.completed = completed;
    this.category = category;
  }

  @CreatedDate
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime updatedAt;

  public void updateCompleted() {
    this.completed = true;
  }

  public void updateTodo(String description, TodoCategory category) {
    this.description = description;
    this.category = category;
  }

}
