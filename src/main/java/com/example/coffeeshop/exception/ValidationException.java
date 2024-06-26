package com.example.coffeeshop.exception;

import com.example.coffeeshop.base.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleException(MethodArgumentNotValidException exception){

        Map<String, Object> errorDto = new HashMap<>();

        List<FieldError> errors = new ArrayList<>();
        /**
         * Get field error in MethodArgumentNotValidException to Record
         */
        exception.getFieldErrors().forEach(fieldError ->
            errors.add(new FieldError(fieldError.getField(), fieldError.getDefaultMessage()))
        );

        errorDto.put("errors", errors);

        return errorDto;
    }

}
