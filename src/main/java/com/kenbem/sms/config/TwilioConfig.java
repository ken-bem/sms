package com.kenbem.sms.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Data
@NoArgsConstructor
@EnableConfigurationProperties
public class TwilioConfig {

    private String accountSid;
    private String authToken;
    private String trialNumber;

}
