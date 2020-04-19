package com.academy.administrative.exception.handler;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ExceptionBodyResponse {

    String message;
    int errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
