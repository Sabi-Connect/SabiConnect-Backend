package com.skilledservice.ClientService.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String e) {
        super(e);
    }
}
