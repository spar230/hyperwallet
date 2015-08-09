package com.hyperwallet.tasks;

import java.util.List;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TasksService {
    public List<Task> getTasks();

    public Task getTask(String taskId);

    public void createNewTask(String taskId, Task task);

    public void updateTask(String taskId, Task task);

    public void deleteTask(String taskId);
}


