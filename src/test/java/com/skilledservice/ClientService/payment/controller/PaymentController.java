package com.skilledservice.ClientService.payment.controller;

import com.skilledservice.ClientService.payment.responses.PaymentResponse;
import com.skilledservice.ClientService.payment.requests.PaymentRequest;
import com.skilledservice.ClientService.payment.responses.ResponseBodyDetails;
import com.skilledservice.ClientService.services.paystack.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/payment")

public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> payStackPayment(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse response = paymentService.makePayment(paymentRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/initiate-payment")
    public ResponseEntity<ResponseBodyDetails<?>> initiatePayStackPayment(@RequestBody PaymentRequest paymentRequest){
        ResponseBodyDetails<?> response = paymentService.initiatePayment(paymentRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/verify-payment/{reference}")
    public ResponseEntity<ResponseBodyDetails<?>> verifyPayStackPayment(@PathVariable String reference) {
        ResponseBodyDetails<?> response = paymentService.verifyPayment(reference);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
