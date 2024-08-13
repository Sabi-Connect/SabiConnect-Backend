package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.config.MailConfig;
//import com.skilledservice.ClientService.config.mailConfig;
import com.skilledservice.ClientService.dto.requests.BrevoMailRequest;
import com.skilledservice.ClientService.dto.requests.Recipient;
import com.skilledservice.ClientService.dto.requests.SendMailRequest;
import com.skilledservice.ClientService.dto.requests.Sender;
import com.skilledservice.ClientService.dto.responses.BrevoMailResponse;
import com.skilledservice.ClientService.services.ServiceUtils.MailService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class MailServiceImp implements MailService {
    private final MailConfig mailConfig;

    public MailServiceImp(MailConfig mailConfig) {
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
