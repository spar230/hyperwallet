package com.hyperwallet.tasks;

import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
public class TasksServiceController implements TasksService {
    @Autowired
    private TasksService tasksService;

    @ApiOperation(value = "Get all the tasks")
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/tasks", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Task> getTasks() {
        return tasksService.getTasks();
    }

    @ApiOperation(value = "Get the task with the given task id")
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/tasks/{taskId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Task getTask(@PathVariable("taskId") String taskId) {
        return tasksService.getTask(taskId);
    }

    @ApiOperation(value = "Create a new task with the given task id")
    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/tasks/{taskId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void createNewTask(@PathVariable("taskId") String taskId, @Validated @RequestBody Task task) {
        tasksService.createNewTask(taskId, task);
    }

    @ApiOperation(value = "Update the task with the given task id")
    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/tasks/{taskId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateTask(@PathVariable("taskId") String taskId, @Validated @RequestBody Task task) {
        tasksService.updateTask(taskId, task);
    }

    @ApiOperation(value = "Delete the task with the given task id")
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/tasks/{taskId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteTask(@PathVariable("taskId") String taskId) {
        tasksService.deleteTask(taskId);
    }
}
