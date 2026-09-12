package com.learning.todoapp.mapper.impl;

import org.springframework.stereotype.Component;

import com.learning.todoapp.domain.CreateTaskRequest;
import com.learning.todoapp.domain.dto.CreateTaskRequestDto;
import com.learning.todoapp.domain.dto.TaskDto;
import com.learning.todoapp.domain.entity.Task;
import com.learning.todoapp.mapper.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority());
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus());
    }
}
