package com.kirmi.wallet.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice("com.kirmi")
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(MyApplicationException.class)
    public ResponseEntity<Object> handleConflict(MyApplicationException ex) {
        HttpStatus responseStatus = ex.getHttpStatus();
        if (responseStatus.is4xxClientError()) {
            log.warn(ex.toString());
        } else if (responseStatus.is5xxServerError()) {
            log.warn(ex.toString());
        } else {
            log.debug(ex.toString());
        }

        return ResponseEntity
                .status(responseStatus)
                .body(Map.of("error", ex.getErrorMessage()));
    }
}
