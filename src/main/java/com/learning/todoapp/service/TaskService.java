package com.learning.todoapp.service;

import java.util.List;
import java.util.UUID;

import com.learning.todoapp.domain.CreateTaskRequest;
import com.learning.todoapp.domain.UpdateTaskRequest;
import com.learning.todoapp.domain.entity.Task;

public interface TaskService {
    public Task createTask(CreateTaskRequest request);

    public List<Task> listTasks();

    public Task updateTask(UUID taskId, UpdateTaskRequest request);

    public void deleteTask(UUID taskId);
}
