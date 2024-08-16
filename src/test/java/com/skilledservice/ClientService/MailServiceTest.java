//package com.skilledservice.ClientService;
//
//import com.skilledservice.ClientService.dto.requests.SendMailRequest;
//import com.skilledservice.ClientService.services.ServiceUtils.MailService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class MailServiceTest {
//
//    @Autowired
//    private MailService mailService;
//
//    @Test
//    public void sendMAilTest() {
//        String email = "miishaqhyaro@gmail.com";
//        SendMailRequest sendMailRequest = new SendMailRequest();
//        sendMailRequest.setRecipientEmail(email);
//        sendMailRequest.setRecipientName("Meshack Yaro");
//        sendMailRequest.setSubject("Welcome "+sendMailRequest.getRecipientName()+" to SabiConnect, your place of ease and comfort");
//        sendMailRequest.setContent("Welcome");
//        var response = mailService.sendMail(sendMailRequest);
//        assertThat(response).isNotNull();
//        assertThat(response).contains("successfully");
//    }
//}
