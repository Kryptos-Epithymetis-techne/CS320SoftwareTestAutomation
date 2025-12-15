package com.task.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task("1234567890", "Task Name", "This is a task description");
        
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("This is a task description", task.getDescription());
    }

    @Test
    void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Description");
        });
    }

    @Test
    void testTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Description");
        });
    }

    @Test
    void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", null, "Description");
        });
    }

    @Test
    void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "This name is way too long for the requirements", "Description");
        });
    }

    @Test
    void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", null);
        });
    }

    @Test
    void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", 
                    "This description is way too long and exceeds the fifty character limit");
        });
    }

    @Test
    void testUpdateName() {
        Task task = new Task("1234567890", "Original Name", "Description");
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
    }

    @Test
    void testUpdateDescription() {
        Task task = new Task("1234567890", "Task Name", "Original Description");
        task.setDescription("Updated Description");
        assertEquals("Updated Description", task.getDescription());
    }

    @Test
    void testUpdateNameTooLong() {
        Task task = new Task("1234567890", "Task Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is way too long for requirements");
        });
    }

    @Test
    void testUpdateDescriptionTooLong() {
        Task task = new Task("1234567890", "Task Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is way too long and exceeds fifty characters");
        });
    }
}
