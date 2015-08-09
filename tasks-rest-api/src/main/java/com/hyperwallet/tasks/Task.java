package com.hyperwallet.tasks;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
public class Task {
    @NotNull(message = " adfasdfasdf message")
    private String Id;

    @NotNull(message = "adsfasdfasfas titile")
    private String title;

    @NotNull(message = "asdfasdfasd description")
    private String description;

    @NotNull (message = "")
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
