package com.example.Controllers;

import com.example.Exceptions.InvalidTodoListException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdviceHandler {

    @ResponseStatus(
            value = HttpStatus.BAD_REQUEST,
            reason = "Todo list requires a name")
    @ExceptionHandler(InvalidTodoListException.class)
    public void handleInvalidTodoListException() {}

}
