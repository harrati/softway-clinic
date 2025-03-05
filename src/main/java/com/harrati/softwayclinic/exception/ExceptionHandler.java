package com.harrati.softwayclinic.exception;

import com.harrati.softwayclinic.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = this.buildErrorResponse(ex);
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.status());
    }

    private ErrorResponse buildErrorResponse(Exception exception){
        if (exception instanceof MethodArgumentTypeMismatchException ||  exception instanceof IllegalArgumentException){
            return new ErrorResponse(exception.getClass().getSimpleName(), HttpStatus.BAD_REQUEST, exception.getMessage());
        }
        return new ErrorResponse(exception.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}