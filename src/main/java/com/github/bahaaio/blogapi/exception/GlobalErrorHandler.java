package com.github.bahaaio.blogapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    ResponseEntity<List<Map<String, String>>> handleInValid(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(
                fieldError -> Map.of(fieldError.getField(), fieldError.getDefaultMessage())
        ).toList();

        return ResponseEntity.badRequest().body(errors);
    }
}
