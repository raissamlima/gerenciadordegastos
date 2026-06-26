package com.example.demo.adapters.inbound.exceptionhandler;

import com.example.demo.domain.exception.InsufficientBalanceException;
import com.example.demo.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InsufficientBalanceException.class)
    private ResponseEntity<ErrorResponse> insufficientBalancerHandler(InsufficientBalanceException exception){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_CONTENT)
                .body(ErrorResponse.of(exception.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT.value()));
    }
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ErrorResponse> userNotFoundHandler(UserNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.of(exception.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
    @ExceptionHandler(NoResourceFoundException.class)
    private ResponseEntity noResourceFoundHandler(NoResourceFoundException exception){
        return ResponseEntity.ok().body("Página inicial do gerenciadordegastos");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of("Erro interno inesperado", HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
