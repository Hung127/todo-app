package com.learning.todoapp.domain.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.learning.todoapp.domain.entity.TaskPriority;
import com.learning.todoapp.domain.entity.TaskStatus;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTaskRequestDto(
        @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH) @Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH) String title,
        @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH) @Nullable String description,
        @Nullable @FutureOrPresent(message = ERROR_MESSAGE_DUE_DAY_FUTURE) LocalDate dueDate,
        @NotNull(message = ERROR_MESSAGE_TASK_STATUS) TaskStatus taskStatus,
        @NotNull(message = ERROR_MESSAGE_TASK_PRIORITY) TaskPriority priority) {

    private static final String ERROR_MESSAGE_TITLE_LENGTH = "Title must be <= 255 chars and >= 1 chars";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH = "Description must be <= 1000 chars";
    private static final String ERROR_MESSAGE_DUE_DAY_FUTURE = "Due day must be present or future";
    private static final String ERROR_MESSAGE_TASK_PRIORITY = "Task priority must be provided";
    private static final String ERROR_MESSAGE_TASK_STATUS = "Task status must be provided";
}
