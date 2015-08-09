package com.hyperwallet.tasks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends ErrorResponse {
    public TaskNotFoundException() {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage("Entity not found.");
        this.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        this.setStatus(HttpStatus.NOT_FOUND.value());
    }

    public TaskNotFoundException(String msg) {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage(msg);
        this.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        this.setStatus(HttpStatus.NOT_FOUND.value());
    }

    public TaskNotFoundException(String msg, Object... msgArgs) {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage(String.format(msg, msgArgs));
        this.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        this.setStatus(HttpStatus.NOT_FOUND.value());
    }
}
