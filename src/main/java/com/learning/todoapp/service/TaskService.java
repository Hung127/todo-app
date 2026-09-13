package com.learning.todoapp.service;

import java.util.List;

import com.learning.todoapp.domain.CreateTaskRequest;
import com.learning.todoapp.domain.entity.Task;

public interface TaskService {
    public Task createTask(CreateTaskRequest request);

    public List<Task> listTasks();
}
