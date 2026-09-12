package com.learning.todoapp.service.impl;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.learning.todoapp.domain.CreateTaskRequest;
import com.learning.todoapp.domain.entity.Task;
import com.learning.todoapp.domain.entity.TaskStatus;
import com.learning.todoapp.domain.repository.TaskRepository;
import com.learning.todoapp.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();
        // public Task(
        // UUID id,
        // String title,
        // String description,
        // LocalDate dueDate,
        // TaskStatus status,
        // TaskPriority priority,
        // Instant created,
        // Instant updated) {
        Task task = new Task(null, request.title(),
                request.description(),
                request.dueDate(), TaskStatus.OPEN,
                request.priority(), now, now);

        return taskRepository.save(task);
    }
}
