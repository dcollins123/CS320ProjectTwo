package com.dcollins.mobileapplication;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId()))
            throw new IllegalArgumentException("Task already exists or is null");
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId))
            throw new IllegalArgumentException("Task does not exist");
        tasks.remove(taskId);
    }

    public void updateTask(String taskId, String name, String description) {
        Task task = tasks.get(taskId);
        if (task == null) throw new IllegalArgumentException("Task does not exist");
        if (name != null) task.setName(name);
        if (description != null) task.setDescription(description);
    }

	public Task getTaskById(String id) {
		// TODO Auto-generated method stub
		return tasks.get(id);
	}
}
