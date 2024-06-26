package com.example.coffeeshop.exception;

import com.example.coffeeshop.base.BaseError;
import com.example.coffeeshop.exception.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class FileUploadException {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public BaseError<?> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex){
        return BaseError.builder()
                .message("Something went wrong!")
                .code(7020)
                .status(false)
                .errors(ex.getMessage())
                .build();
    }

}
