package task.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import task.exception.ClientNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    private static final String MESSAGE = "message";

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Map<String, String>> createClientNotFoundResponse() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(Map.of(MESSAGE, "Client has not been found"));
    }

}
