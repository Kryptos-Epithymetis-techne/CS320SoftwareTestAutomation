package com.task.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
    
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertTrue(taskService.addTask(task));
        assertEquals(task, taskService.getTask("1234567890"));
    }

    @Test
    void testAddDuplicateTaskId() {
        Task task1 = new Task("1234567890", "Task One", "First Task");
        Task task2 = new Task("1234567890", "Task Two", "Second Task");
        
        taskService.addTask(task1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);
        
        assertTrue(taskService.deleteTask("1234567890"));
        assertNull(taskService.getTask("1234567890"));
    }

    @Test
    void testDeleteNonExistentTask() {
        assertFalse(taskService.deleteTask("9999999999"));
    }

    @Test
    void testUpdateName() {
        Task task = new Task("1234567890", "Original Name", "Task Description");
        taskService.addTask(task);
        
        assertTrue(taskService.updateName("1234567890", "Updated Name"));
        assertEquals("Updated Name", taskService.getTask("1234567890").getName());
    }

    @Test
    void testUpdateDescription() {
        Task task = new Task("1234567890", "Task Name", "Original Description");
        taskService.addTask(task);
        
        assertTrue(taskService.updateDescription("1234567890", "Updated Description"));
        assertEquals("Updated Description", taskService.getTask("1234567890").getDescription());
    }

    @Test
    void testUpdateNonExistentTask() {
        assertFalse(taskService.updateName("9999999999", "New Name"));
        assertFalse(taskService.updateDescription("9999999999", "New Description"));
    }
}
