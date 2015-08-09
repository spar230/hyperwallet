package com.hyperwallet.tasks.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed"})
public class ErrorResponse extends RuntimeException{
    protected Date timestamp;
    protected Integer status;
    protected String error;
    protected String exception;
    protected String message;
    protected String path;

    public ErrorResponse(Date timestamp, Integer status, String error, String exception, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.path = path;
        this.message = message;
    }

    public ErrorResponse() {
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return this.exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        return "ErrorResponse{timestamp=" + this.timestamp + ", status=" + this.status + ", error=\'" + this.error + '\'' + ", exception=\'" + this.exception + '\'' + ", message=\'" + this.message + '\'' + ", path=\'" + this.path + '\'' + '}';
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void throwException(ErrorResponse response) {
        this.setError(response.getError());
        this.setException(response.getException());
        this.setMessage(response.getMessage());
        this.setPath(response.getPath());
        this.setStatus(response.getStatus());
        this.setTimestamp(response.getTimestamp());
        this.setStackTrace(response.getStackTrace());
        throw this;
    }

}
