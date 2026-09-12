package com.learning.todoapp.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.learning.todoapp.domain.entity.TaskPriority;
import com.learning.todoapp.domain.entity.TaskStatus;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status) {
}
