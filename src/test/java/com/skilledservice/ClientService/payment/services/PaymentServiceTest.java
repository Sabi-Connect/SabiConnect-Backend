package com.skilledservice.ClientService.payment.services;

import com.google.gson.JsonObject;
import com.skilledservice.ClientService.config.AppConfig;
import com.skilledservice.ClientService.dto.requests.PaymentRequest;
import com.skilledservice.ClientService.dto.responses.PaymentResponse;
import com.skilledservice.ClientService.payment.responses.PayStackData;
import com.skilledservice.ClientService.payment.responses.ResponseBodyDetails;
import com.skilledservice.ClientService.services.paystack.PaymentService;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PaymentServiceTest {
    @Mock
    private AppConfig appConfig;
    @Autowired
    private PaymentService paymentService;
    private MockWebServer mockWebServer;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @Test
    public void makePaymentTest(){
        PaymentRequest request = new PaymentRequest();
        request.setEmail("miishaqhyaro@gmail.com");
        request.setAmount(BigDecimal.valueOf(7000.00));
        PaymentResponse response = paymentService.makePayment(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void initiatePaymentSuccessTest(){

        when(appConfig.getPayStackInitiatePayment()).thenReturn(mockWebServer.url("/").toString());

        JsonObject mockResponseBody = new JsonObject();
        mockResponseBody.addProperty("status", "success");
        mockResponseBody.addProperty("message", "Authorization Url created");

        JsonObject data = new JsonObject();
        data.addProperty("authorization_url", "https://checkout.paystack.com/mock_authorization_url");
        data.addProperty("access_code", "mock_access_coe");
        data.addProperty("reference", "mock_reference");

        mockResponseBody.add("data", data);

        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody(mockResponseBody.toString());
        mockWebServer.enqueue(mockResponse);

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setEmail("test@gmail.com");
        paymentRequest.setAmount(BigDecimal.valueOf(7000));

        ResponseBodyDetails<?> responseBodyDetails = paymentService.initiatePayment(paymentRequest);

        String expectedMessage = mockResponseBody.get("message").getAsString();
        JsonObject expectedData = mockResponseBody.get("data").getAsJsonObject();
        String expectedBaseUrl = "https://checkout.paystack.com/";
        String expectedAccessCode = expectedData.get("access_code").getAsString();
        String expectedReference = expectedData.get("reference").getAsString();

        Assertions.assertNotNull(responseBodyDetails);
        assertEquals(expectedMessage, responseBodyDetails.getMessage());

        PayStackData actualData = (PayStackData) responseBodyDetails.getData();
        Assertions.assertNotNull(actualData);

        assertTrue(actualData.getAuthorizationUrl().startsWith(expectedBaseUrl));
        Assertions.assertNotNull(actualData.getAccessCode());
        Assertions.assertNotNull(actualData.getReference());

    }

}
