package com.skilledservice.ClientService.utils;

import com.skilledservice.ClientService.exceptions.ProjectException;

public class Validations {
    public static void verifyEmailAddress(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String emailRegex2 = "([a-z]\\.)?[a-z]+@(semicolon|enum|learnspace|native.semicolon).africa";

        if (!email.matches(emailRegex) && !email.matches(emailRegex2))throw new ProjectException("Invalid email address");

    }

}
