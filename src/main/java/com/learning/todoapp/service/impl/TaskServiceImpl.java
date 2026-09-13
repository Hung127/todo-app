package com.learning.todoapp.service.impl;

import java.util.List;
import java.util.UUID;
import java.time.Instant;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.learning.todoapp.domain.CreateTaskRequest;
import com.learning.todoapp.domain.UpdateTaskRequest;
import com.learning.todoapp.domain.entity.Task;
import com.learning.todoapp.domain.entity.TaskStatus;
import com.learning.todoapp.domain.repository.TaskRepository;
import com.learning.todoapp.exception.TaskNotFoundException;
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

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest request) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        task.setTitle(request.title());
        task.setPriority(request.priority());
        task.setStatus(request.status());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setUpdated(Instant.now());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }
}
