package com.example.wine_tracker.exception;

import com.example.wine_tracker.dto.ErrorResponse;
import com.example.wine_tracker.dto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WineNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleWineNotFound(WineNotFoundException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(404);
        error.setError("Not Found");
        error.setMessage(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage())
        );

        ValidationErrorResponse error = new ValidationErrorResponse();

        error.setTimestamp(LocalDateTime.now());
        error.setStatus(400);
        error.setError("Bad Request");
        error.setMessages(validationErrors);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
