package com.hyperwallet.tasks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class TasksServiceInternalErrorException extends ErrorResponse {
    public TasksServiceInternalErrorException() {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage("Tasks service internal server error.");
        this.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        this.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public TasksServiceInternalErrorException(String msg) {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage(msg);
        this.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        this.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public TasksServiceInternalErrorException(String msg, Object... msgArgs) {
        super();
        this.setTimestamp(new Date());
        this.setException(this.getClass().getName());
        this.setMessage(String.format(msg, msgArgs));
        this.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        this.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
