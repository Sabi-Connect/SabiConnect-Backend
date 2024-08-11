package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.config.mailConfig;
import com.skilledservice.ClientService.dto.request.BrevoMailRequest;
import com.skilledservice.ClientService.dto.request.Recipient;
import com.skilledservice.ClientService.dto.request.SendMailRequest;
import com.skilledservice.ClientService.dto.request.Sender;
import com.skilledservice.ClientService.dto.response.BrevoMailResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class MailServiceImp implements MailService{
    private final mailConfig mailConfig;

    public MailServiceImp(mailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    @Override
    public String sendMail(SendMailRequest sendMailRequest) {

        RestTemplate restTemplate = new RestTemplate();
        String url = mailConfig.getMailApiUrl();

        BrevoMailRequest request = new BrevoMailRequest();
        request.setSender(new Sender());
        request.setSubject(sendMailRequest.getSubject());
        request.setContent(sendMailRequest.getContent());
        request.setRecipients(List.of(new Recipient(sendMailRequest.getRecipientName(), sendMailRequest.getRecipientEmail())));
        request.setContent(sendMailRequest.getContent());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", mailConfig.getMailApiKey());
        headers.set("accept", MediaType.APPLICATION_JSON.toString());
        RequestEntity<?> httpRequest = new RequestEntity<>(request, headers, HttpMethod.POST, URI.create(url));
        ResponseEntity<BrevoMailResponse> response = restTemplate.postForEntity(url, httpRequest, BrevoMailResponse.class);
        if (response.getBody()!=null && response.getStatusCode() == HttpStatusCode.valueOf(201)) return "mail sent successfully";
        throw new RuntimeException("Error sending mail");
    }
}
