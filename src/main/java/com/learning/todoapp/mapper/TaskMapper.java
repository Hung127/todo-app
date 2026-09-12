package com.learning.todoapp.mapper;

import com.learning.todoapp.domain.CreateTaskRequest;
import com.learning.todoapp.domain.dto.CreateTaskRequestDto;
import com.learning.todoapp.domain.dto.TaskDto;
import com.learning.todoapp.domain.entity.Task;

public interface TaskMapper {
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    public TaskDto toDto(Task task);
}
