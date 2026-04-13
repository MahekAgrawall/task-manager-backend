package com.example.taskmanageproject.repository;

import com.example.taskmanageproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}