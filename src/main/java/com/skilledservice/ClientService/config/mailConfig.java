package com.skilledservice.ClientService.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class mailConfig {

    @Value("${mail.api.key}")
    private String mailApiKey;
    @Value("{mail.api.url}")
    private String mailApiUrl;
}
