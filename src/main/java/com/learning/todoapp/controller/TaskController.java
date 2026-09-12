package com.learning.todoapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.todoapp.domain.CreateTaskRequest;
import com.learning.todoapp.domain.dto.CreateTaskRequestDto;
import com.learning.todoapp.domain.dto.TaskDto;
import com.learning.todoapp.domain.entity.Task;
import com.learning.todoapp.mapper.TaskMapper;
import com.learning.todoapp.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
        CreateTaskRequest request = taskMapper.fromDto(createTaskRequestDto);
        Task createdTask = taskService.createTask(request);
        TaskDto taskDto = taskMapper.toDto(createdTask);

        // 201 Created
        return new ResponseEntity<TaskDto>(taskDto, HttpStatus.CREATED);
    }

}
