package com.dcollins.mobileapplication.test;

import com.dcollins.mobileapplication.Task;
import com.dcollins.mobileapplication.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    private TaskService service;

    @BeforeEach
    public void setup() {
        service = new TaskService();
        service.addTask(new Task("T12345", "Code Review", "Review code for release"));
    }

    @Test
    public void testAddTask() {
        assertDoesNotThrow(() -> service.addTask(new Task("T54321", "Bug Fix", "Fix bugs before release")));
        assertNotNull(service.getTaskById("T54321"));
    }

    @Test
    public void testAddDuplicateTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task("T12345", "Code Review", "Review code for release"));
        });
    }

    @Test
    public void testDeleteTask() {
        assertDoesNotThrow(() -> service.deleteTask("T12345"));
        assertNull(service.getTaskById("T12345"));
    }

    @Test
    public void testDeleteNonexistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("nonexistent");
        });
    }

    @Test
    public void testUpdateTask() {
        assertDoesNotThrow(() -> service.updateTask("T12345", "Final Review", "Final review before release"));
        Task task = service.getTaskById("T12345");
        assertAll("Validate task update",
            () -> assertEquals("Final Review", task.getName()),
            () -> assertEquals("Final review before release", task.getDescription())
        );
    }
    // Additional tests...
}
