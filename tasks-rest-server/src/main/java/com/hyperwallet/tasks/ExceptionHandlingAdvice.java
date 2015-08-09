package com.hyperwallet.tasks;

import com.hyperwallet.tasks.exceptions.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Srikanthan Parameshwaran
 * @version 1.0.0
 * @since 1.0.0
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionHandlingAdvice {

    @Autowired
    HttpServletRequest servletRequest;

    @ExceptionHandler(value = ErrorResponse.class)
    @ResponseBody
    public ResponseEntity handleErrorResponse(ErrorResponse errorResponse) {
        errorResponse.setPath(servletRequest.getRequestURI());
        ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));

        return response;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ResponseEntity handleRuntimeException(RuntimeException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setPath(servletRequest.getRequestURI());
        errorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setException(exception.getClass().getName());
        errorResponse.setTimestamp(new Date());
        errorResponse.setMessage(exception.getMessage());

        ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}

