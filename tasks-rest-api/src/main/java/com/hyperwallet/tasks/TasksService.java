package com.hyperwallet.tasks;

import com.hyperwallet.tasks.exceptions.TaskExistsException;
import com.hyperwallet.tasks.exceptions.TaskNotFoundException;

import java.util.List;

/**
 * The <code>TasksService</code> provides capability to manage (retrieve, add, update and remove) tasks/todos.
 *
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TasksService {
    /**
     * Get all the tasks
     *
     * @return list of all the tasks
     */
    public List<Task> getTasks();

    /**
     * Get the task associated with the given taskId
     *
     * @param taskId id of the task to get
     * @return task associated with the id
     * @throws TaskNotFoundException if failed to find any task associated with the taskId
     */
    public Task getTask(String taskId) throws TaskNotFoundException;

    /**
     * Added a new task to the task list
     *
     * @param taskId id of the new task
     * @param task   new task to add
     * @throws TaskExistsException if a task already exists with the given taskId
     */
    public void addTask(String taskId, Task task) throws TaskExistsException;

    /**
     * Update an existing task in the task list
     *
     * @param taskId id of the task to update
     * @param task   updated task
     * @throws TaskNotFoundException if faild to find any task for the task id
     */
    public void updateTask(String taskId, Task task) throws TaskNotFoundException;

    /**
     * Remove the task associated with the given task id from the task list
     *
     * @param taskId id fo the task to remove
     * @throws TaskNotFoundException if faild to find any task for the task id
     */
    public void deleteTask(String taskId) throws TaskNotFoundException;
}


