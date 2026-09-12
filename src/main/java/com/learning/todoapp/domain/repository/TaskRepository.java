package com.learning.todoapp.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.todoapp.domain.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

}
