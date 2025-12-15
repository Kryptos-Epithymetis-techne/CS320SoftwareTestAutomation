package com.task.service;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    // Add task with unique ID
    public boolean addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        
        tasks.put(task.getTaskId(), task);
        return true;
    }

    // Delete task by ID
    public boolean deleteTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            return false;
        }
        
        tasks.remove(taskId);
        return true;
    }

    // Update task fields by ID
    public boolean updateName(String taskId, String name) {
        Task task = tasks.get(taskId);
        if (task == null) {
            return false;
        }
        task.setName(name);
        return true;
    }

    public boolean updateDescription(String taskId, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            return false;
        }
        task.setDescription(description);
        return true;
    }

    // Get task by ID (useful for testing)
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
