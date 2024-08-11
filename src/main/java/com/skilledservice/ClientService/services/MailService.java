package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.SendMailRequest;

public interface MailService {
    String sendMail(SendMailRequest sendMailRequest);
}
