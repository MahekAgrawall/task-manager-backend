package com.example.taskmanageproject.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskRequest {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
