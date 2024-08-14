package com.skilledservice.ClientService.services.paystack;


import com.skilledservice.ClientService.dto.requests.PaymentRequest;
import com.skilledservice.ClientService.dto.responses.PaymentResponse;

public interface PaymentService {

    PaymentResponse makePayment(PaymentRequest paymentRequest);

}
