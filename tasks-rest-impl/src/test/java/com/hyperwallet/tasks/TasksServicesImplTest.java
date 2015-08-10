package com.hyperwallet.tasks;

import com.hyperwallet.tasks.exceptions.TaskExistsException;
import com.hyperwallet.tasks.exceptions.TaskNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IntegrationTestConfig.class)
public class TasksServicesImplTest {
    @Autowired
    TasksServiceImpl tasksService;

    @Before
    public void setup() {

    }

    @Test
    public void testGetEmptyTasks() {
        List<Task> tasks = tasksService.getTasks();
        assertThat(tasks).isNotNull();
        assertThat(tasks).isEmpty();
    }

    @Test
    public void testGetTasks() {
        Task task = getTask();
        tasksService.addTask(task.getId(), task);
        List<Task> tasks = tasksService.getTasks();
        assertThat(tasks).isNotNull();
        assertThat(tasks).isNotEmpty();
        assertThat(tasks.size()).isEqualTo(1);
        tasksService.deleteTask(task.getId());
    }

    @Test(expected = TaskNotFoundException.class)
    public void testGetTaskWithInvalidTaskId() {
        tasksService.getTask("123");
    }

    @Test(expected = TaskNotFoundException.class)
    public void testGetTaskWithEmptyTaskId() {
        tasksService.getTask("");
    }

    @Test(expected = TaskNotFoundException.class)
    public void testGetTaskWithNullTaskId() {
        tasksService.getTask(null);
    }

    @Test
    public void testGetTask() {
        tasksService.addTask(getTask().getId(), getTask());
        Task task = tasksService.getTask(getTask().getId());
        assertThat(task).isNotNull();
        assertThat(task.getId()).isEqualToIgnoringCase(getTask().getId());
        tasksService.deleteTask(task.getId());
    }

    @Test
    public void testAddTask() {
        tasksService.addTask(getTask().getId(), getTask());
        Task task = tasksService.getTask(getTask().getId());
        assertThat(task).isNotNull();
        assertThat(task.getId()).isEqualToIgnoringCase(getTask().getId());
        tasksService.deleteTask(task.getId());
    }

    @Test(expected = TaskExistsException.class)
    public void testAddingExistingTask() {
        try {
            tasksService.addTask(getTask().getId(), getTask());
            tasksService.addTask(getTask().getId(), getTask());
        } catch (TaskExistsException tex) {
            tasksService.deleteTask(getTask().getId());
            throw tex;
        }
    }

    @Test
    public void testUpdateTask() {
        Task initialTask = getTask();
        initialTask.setCompleted(true);
        tasksService.addTask(initialTask.getId(), initialTask);

        Task task = tasksService.getTask(initialTask.getId());
        assertThat(task).isNotNull();
        assertThat(task.getId()).isEqualToIgnoringCase(initialTask.getId());
        assertThat(task.isCompleted()).isTrue();

        initialTask.setCompleted(false);
        tasksService.updateTask(initialTask.getId(), initialTask);

        task = tasksService.getTask(initialTask.getId());
        assertThat(task).isNotNull();
        assertThat(task.getId()).isEqualToIgnoringCase(initialTask.getId());
        assertThat(task.getTitle()).isEqualToIgnoringCase(initialTask.getTitle());
        assertThat(task.getDescription()).isEqualToIgnoringCase(initialTask.getDescription());
        assertThat(task.isCompleted()).isFalse();

        tasksService.deleteTask(task.getId());
    }

    @Test(expected = TaskNotFoundException.class)
    public void testUpdateTaskWithNewTask() {
        Task task = getTask();
        tasksService.updateTask(task.getId(), task);
    }

    @Test
    public void testDeleteTask() {
        Task initialTask = getTask();
        tasksService.addTask(initialTask.getId(), initialTask);

        Task task = tasksService.getTask(initialTask.getId());
        assertThat(task).isNotNull();
        assertThat(task.getId()).isEqualToIgnoringCase(initialTask.getId());

        tasksService.deleteTask(initialTask.getId());

        for (Task t : tasksService.getTasks()) {
            assertThat(t.getId()).isNotEqualTo(initialTask.getId());
        }
    }

    @Test(expected = TaskNotFoundException.class)
    public void testDeleteTaskWithInvalidTaskId() {
        tasksService.deleteTask("123");
    }

    private Task getTask() {
        Task task = new Task();
        task.setId("CookDinnerTask");
        task.setTitle("Cook Dinner Tonight");
        task.setDescription("Cook a nice dinner fro 10 people.");
        task.setCompleted(false);
        return task;
    }

}
