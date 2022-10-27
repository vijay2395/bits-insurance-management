package com.bits.dda.insurancemanagement.exception

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class AppExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class)

    @ExceptionHandler(RequestFailedException.class)
    protected ResponseEntity<ErrorResponse> handleRequestFailedException(RequestFailedException ex) {
        log.error('Request failed with exception: {}', ex.message)
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(error: ex.message, status: ex.status.value()), ex.status)
    }
}
