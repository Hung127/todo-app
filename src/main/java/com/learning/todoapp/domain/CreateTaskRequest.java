package com.learning.todoapp.domain;

import java.time.LocalDate;

import com.learning.todoapp.domain.entity.TaskPriority;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority) {

}
