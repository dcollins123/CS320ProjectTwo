package com.dcollins.mobileapplication.test;

import com.dcollins.mobileapplication.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private Task task;

    @BeforeEach
    public void setup() {
        task = new Task("T12345", "Code Review", "Review code for release");
    }

    @Test
    public void testTaskCreation() {
        assertAll("Test Task Creation",
            () -> assertEquals("Code Review", task.getName()),
            () -> assertEquals("Review code for release", task.getDescription())
        );
    }

    @Test
    public void testInvalidTaskID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("T12345678901", "Code Review", "Review code for release");
        });
    }
}
