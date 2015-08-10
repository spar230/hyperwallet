package com.hyperwallet.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class TasksServiceImpl implements TasksService {

    @Autowired
    private InMemoryTasksServiceImpl tasksService;

    public List<Task> getTasks() {
        return tasksService.getTasks();
    }

    public Task getTask(String taskId) {
        return tasksService.getTask(taskId);
    }

    public void addTask(String taskId, Task task) {
        tasksService.addTask(taskId, task);
    }

    public void updateTask(String taskId, Task task) {
        tasksService.updateTask(taskId, task);
    }

    public void deleteTask(String taskId) {
        tasksService.deleteTask(taskId);
    }
}
