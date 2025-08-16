package com.example.todolist.domain.enumerate;

import lombok.Getter;

@Getter
public enum TodoCategory {
  STUDY("공부/이론 정리"),
  PROJECT("개인/팀 프로젝트"),
  READING_DOCS("문서/블로그 읽기"),
  CODING_PRACTICE("코딩 연습"),
  INTERVIEW_PREP("면접 준비"),
  NETWORKING("네트워킹/스터디"),
  LIFE("생활/일상");

  private final String description;

  TodoCategory(String description) {
    this.description = description;
  }
}