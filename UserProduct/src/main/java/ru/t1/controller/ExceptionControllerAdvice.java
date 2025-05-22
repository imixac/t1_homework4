package ru.t1.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.t1.dto.ErrorResponse;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ErrorResponse("Не найдена сущность", ex.getMessage());
    }


}
