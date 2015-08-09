package com.hyperwallet.tasks;

import com.hyperwallet.tasks.exceptions.TaskExistsException;
import com.hyperwallet.tasks.exceptions.TaskNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
class InMemoryTasksServiceImpl {
    private static Map<String, Task> taskMap = new HashMap<String, Task>();

    public InMemoryTasksServiceImpl() {
    }

    public List<Task> getTasks() {
        return new ArrayList<Task>(taskMap.values());
    }

    public Task getTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new TaskNotFoundException("Failed to find any task with task id '%s'", taskId);
        }

        return taskMap.get(taskId);
    }

    public void createNewTask(String taskId, Task task) {
        if (taskMap.containsKey(taskId)) {
            throw new TaskExistsException("Task exists for the given task id '%s', use PUT to update the task", taskId);
        }

        task.setId(taskId);
        taskMap.put(taskId, task);
    }

    public void updateTask(String taskId, Task task) {
        if (!taskMap.containsKey(taskId)) {
            throw new TaskNotFoundException("Failed to find any task with task id '%s', use POST to create a new task", taskId);
        }

        task.setId(taskId);
        taskMap.put(taskId, task);
    }

    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new TaskNotFoundException("Failed to find any task with task id '%s'", taskId);
        }
        taskMap.remove(taskId);
    }
}
