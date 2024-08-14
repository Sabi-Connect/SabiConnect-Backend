package com.skilledservice.ClientService.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String e) {
        super(e);
    }
}
