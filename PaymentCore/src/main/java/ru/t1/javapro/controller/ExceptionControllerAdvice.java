package ru.t1.javapro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.t1.javapro.dto.ErrorResponse;
import ru.t1.javapro.exceptions.IntegrationException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(IntegrationException.class)
    public ErrorResponse handleEntityNotFoundException(IntegrationException ex) {
        return new ErrorResponse("Произошла ошибка внешнего сервиса", ex.getMessage());
    }


}
