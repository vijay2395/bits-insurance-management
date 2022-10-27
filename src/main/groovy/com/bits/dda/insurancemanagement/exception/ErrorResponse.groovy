package com.bits.dda.insurancemanagement.exception

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponse {
     ErrorResponse(String error = 'Something went wrong', Integer status = 500 , String message = 'Default error') {
        this.error = error
        this.timestamp = (new Date()).getTime()
        this.status = status
        this.message = message
    }

    String error
    Long timestamp
    Integer status
    String message
}
