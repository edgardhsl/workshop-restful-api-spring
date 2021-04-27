package com.github.isaacscardoso.resources.advices;

import com.github.isaacscardoso.services.exceptions.StandardError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class WorkshopAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StandardError handleValidationError(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<String> messages = bindingResult.getAllErrors().stream().map(
                DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        return new StandardError(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<StandardError> handleResponseStatusException(ResponseStatusException e) {
        String errorMessage = e.getMessage();
        HttpStatus statusCode = e.getStatus();
        StandardError error = new StandardError(errorMessage);

        return new ResponseEntity<>(error, statusCode);
    }
}
