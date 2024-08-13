package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.PaymentRequest;
import com.skilledservice.ClientService.dto.responses.PaymentResponse;
import com.skilledservice.ClientService.services.paystack.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaymentServiceTest {
    @Autowired
    private PaymentServiceImpl paymentService;

    @Test
    public void makePaymentTest(){
        PaymentRequest request = new PaymentRequest();
        request.setEmail("miishaqhyaro@gmail.com");
        request.setAmount(BigDecimal.valueOf(7000.00));
        PaymentResponse response = paymentService.makePayment(request);
        assertThat(response).isNotNull();


    }


}
