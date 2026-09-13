package com.learning.todoapp.domain;

import java.time.LocalDate;

import com.learning.todoapp.domain.entity.TaskPriority;
import com.learning.todoapp.domain.entity.TaskStatus;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority) {

}
