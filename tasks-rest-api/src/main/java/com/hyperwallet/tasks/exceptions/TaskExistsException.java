package com.hyperwallet.tasks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TaskExistsException extends ErrorResponse {
    public TaskExistsException() {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage("Task exists.");
        this.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        this.setStatus(HttpStatus.BAD_REQUEST.value());
    }

    public TaskExistsException(String msg) {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage(msg);
        this.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        this.setStatus(HttpStatus.BAD_REQUEST.value());
    }

    public TaskExistsException(String msg, Object... msgArgs) {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage(String.format(msg, msgArgs));
        this.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        this.setStatus(HttpStatus.BAD_REQUEST.value());
    }
}
