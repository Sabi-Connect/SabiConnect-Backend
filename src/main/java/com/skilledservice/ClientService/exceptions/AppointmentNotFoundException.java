package com.skilledservice.ClientService.exceptions;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String e) {
        super(e);
    }
}
