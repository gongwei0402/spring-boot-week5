package com.cogent.week5.demo.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{
    private HttpStatus httpStatus;
    private String message;

    public ApiException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
    public ApiException(String customMessage, HttpStatus httpStatus, String message){
        super(customMessage);
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
