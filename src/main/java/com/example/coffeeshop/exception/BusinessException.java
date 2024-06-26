package com.example.coffeeshop.exception;

import com.example.coffeeshop.base.BaseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class BusinessException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleBusinessException(ResponseStatusException e){

        var baseError = BaseError.builder()
                .message("Something went wrong!")
                .code(404)
                .status(false)
                .errors(e.getReason())
                .build();

        return new  ResponseEntity<>(baseError, e.getStatusCode());
    }

}
