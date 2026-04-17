package com.example.taskmanageproject.service;
import com.example.taskmanageproject.dto.TaskRequest;
import com.example.taskmanageproject.dto.TaskResponse;
import com.example.taskmanageproject.entity.Task;
import com.example.taskmanageproject.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription()
                ))
                .toList();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id).orElseThrow();

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());

        return taskRepository.save(task);
    }


    public TaskResponse createTask(TaskRequest request) {

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        Task saved = taskRepository.save(task);

        return new TaskResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription()
        );
    }
}