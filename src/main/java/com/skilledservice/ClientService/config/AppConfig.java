package com.skilledservice.ClientService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${paystack.secret.key}")
    private String payStackSecretKey;
    @Value("${paystack.verify.payment.url}")
    private String payStackVerifyPaymentUrl;
    @Value("${paystack.initiate.payment}")
    private String payStackInitiatePayment;

    public String getPayStackSecretKey() {
        return payStackSecretKey;
    }

    public String getPayStackVerifyPaymentUrl() {
        return payStackVerifyPaymentUrl;
    }

    public String getPayStackInitiatePayment() {
        return payStackInitiatePayment;
    }
}
