package com.clinico.exception.handler;

import com.clinico.dto.EmptyJsonBody;
import com.clinico.exception.InvalidValue;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({InvalidValue.class})
    public ResponseEntity handleInvalidValue(InvalidValue invalidValue) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(new EmptyJsonBody(),headers, HttpStatus.NOT_FOUND);
    }
}
