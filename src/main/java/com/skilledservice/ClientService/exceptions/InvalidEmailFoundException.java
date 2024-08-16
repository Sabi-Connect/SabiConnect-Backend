package com.skilledservice.ClientService.exceptions;

public class InvalidEmailFoundException extends RuntimeException {
    public InvalidEmailFoundException(String e) {
        super(e);
    }
}
