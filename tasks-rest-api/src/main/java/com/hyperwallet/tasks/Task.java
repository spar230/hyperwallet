package com.hyperwallet.tasks;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * The <code>Task</code> class represents attributes/properties of a task.
 *
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
public class Task {
    private String Id;

    @NotBlank(message = "Please enter a valid task title.")
    private String title;

    @NotBlank(message = "Please enter a valid task description.")
    private String description;

    private boolean completed;

    public Task() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
