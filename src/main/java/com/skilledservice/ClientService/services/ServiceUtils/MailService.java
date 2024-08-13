package com.skilledservice.ClientService.services.ServiceUtils;

import com.skilledservice.ClientService.dto.requests.SendMailRequest;

public interface MailService {
    String sendMail(SendMailRequest sendMailRequest);
}
