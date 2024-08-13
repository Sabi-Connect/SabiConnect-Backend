package com.skilledservice.ClientService.services.paystack;

import com.skilledservice.ClientService.config.AppConfig;
import com.skilledservice.ClientService.dto.requests.PaymentRequest;
import com.skilledservice.ClientService.dto.responses.PaymentResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final AppConfig appConfig;
//    private final String PAYSTACK_URL = "https://api.paystack.co/transaction/initialize";

    public PaymentServiceImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public PaymentResponse makePayment(PaymentRequest paymentRequest) {
        String authorization = "Bearer " + appConfig.getPayStackSecretKey();
        String payStackUrl = appConfig.getPayStackInitiatePayment();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PaymentRequest> request = new HttpEntity<>(paymentRequest, headers);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<PaymentResponse> response = restTemplate.postForEntity(payStackUrl, request, PaymentResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.err.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            System.err.println("Error making payment request: " + e.getMessage());
            throw new RuntimeException("Failed to make payment request", e);
        }
    }
}
