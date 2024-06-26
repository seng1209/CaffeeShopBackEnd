package com.example.coffeeshop.exception;

import com.example.coffeeshop.base.BaseError;
import com.example.coffeeshop.base.FieldError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class InputException {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Object handleInputException(DataIntegrityViolationException exception){

        return BaseError.builder()
                .message("Something went wrong!")
                .code(403)
                .status(true)
                .errors(exception.getMessage())
                .build();
    }

}
