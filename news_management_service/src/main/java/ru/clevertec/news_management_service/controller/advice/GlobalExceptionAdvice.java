package ru.clevertec.news_management_service.controller.advice;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.clevertec.news_management_service.dto.error.MultipleResponseError;
import ru.clevertec.news_management_service.dto.error.SingleResponseError;
import ru.clevertec.news_management_service.dto.error.ValidationError;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        List<ValidationError> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {

            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            ValidationError validationError = new ValidationError(field, message);
            errors.add(validationError);
        });

        MultipleResponseError<ValidationError> error = new MultipleResponseError<>("Validation error", errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<SingleResponseError> handleEntityNotFoundException(EntityNotFoundException exception) {
        return new ResponseEntity<>(new SingleResponseError(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
