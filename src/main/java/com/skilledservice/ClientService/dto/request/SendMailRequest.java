package com.skilledservice.ClientService.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SendMailRequest {
    private String recipientEmail;
    private String subject;
    private String recipientName;
    private String content;
}
