package com.hyperwallet.tasks;

import com.hyperwallet.tasks.exceptions.TaskExistsException;
import com.hyperwallet.tasks.exceptions.TaskNotFoundException;
import com.hyperwallet.tasks.exceptions.TasksServiceInternalErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryTasksServiceImpl.class);

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

        try {
            return taskMap.get(taskId);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
            throw new TasksServiceInternalErrorException();
        }
    }

    public void addTask(String taskId, Task task) {
        if (taskMap.containsKey(taskId)) {
            throw new TaskExistsException("Task exists for the given task id '%s', use PUT to update the task", taskId);
        }

        try {
            task.setId(taskId);
            taskMap.put(taskId, task);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
            throw new TasksServiceInternalErrorException();
        }
    }

    public void updateTask(String taskId, Task task) {
        if (!taskMap.containsKey(taskId)) {
            throw new TaskNotFoundException("Failed to find any task with task id '%s', use POST to create a new task", taskId);
        }

        try {
            task.setId(taskId);
            taskMap.put(taskId, task);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
            throw new TasksServiceInternalErrorException();
        }
    }

    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new TaskNotFoundException("Failed to find any task with task id '%s'", taskId);
        }

        try {
            taskMap.remove(taskId);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
            throw new TasksServiceInternalErrorException();
        }
    }
}
