package com.skilledservice.ClientService.services.paystack;


import com.skilledservice.ClientService.payment.requests.PaymentRequest;
import com.skilledservice.ClientService.dto.responses.PaymentResponse;
import com.skilledservice.ClientService.payment.responses.ResponseBodyDetails;

public interface PaymentService {

    PaymentResponse makePayment(PaymentRequest paymentRequest);

    ResponseBodyDetails<?> initiatePayment(PaymentRequest paymentRequest);

    ResponseBodyDetails<?> verifyPayment(String reference);

}