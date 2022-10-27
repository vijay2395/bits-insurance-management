package com.bits.dda.insurancemanagement.exception

import org.springframework.http.HttpStatus

class RequestFailedException extends RuntimeException {

    String message
    HttpStatus status
    RequestFailedException(String message = 'Request Failed!', HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR) {
        super(message)
        setMessage(message)
        setStatus(status)
    }


}
