package com.medical.presentation.advice;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerAllExceptions(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(NonExistingResourceException.class)
    public ResponseEntity<Object> handlerNonExistingResourceException(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND , LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handlerIllegalArgumentException(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(ExistingResourceException.class)
    public ResponseEntity<Object> handlerExistingResourceException(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.CONFLICT, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(DataInconsistencyException.class)
    public ResponseEntity<Object> handlerDataInconsistencyException(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.CONFLICT , LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
