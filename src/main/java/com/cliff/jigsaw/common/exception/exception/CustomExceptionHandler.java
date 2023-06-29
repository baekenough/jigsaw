package com.cliff.jigsaw.common.exception.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<CustomErrorResponseEntity> handleCustomException(CustomException e) {
        return CustomErrorResponseEntity.toResponseEntity(e.getErrorCode());
    }

}
