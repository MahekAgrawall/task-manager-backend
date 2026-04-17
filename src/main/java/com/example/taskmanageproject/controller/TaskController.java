package com.example.taskmanageproject.controller;

import com.example.taskmanageproject.dto.TaskRequest;
import com.example.taskmanageproject.dto.TaskResponse;
import com.example.taskmanageproject.entity.Task;
import com.example.taskmanageproject.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/tasks")
    public TaskResponse createTask(@Valid @RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping("/tasks")
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }
}