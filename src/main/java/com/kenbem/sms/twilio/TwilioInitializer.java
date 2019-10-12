package com.kenbem.sms.twilio;

import com.kenbem.sms.config.TwilioConfig;
import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    private  final static Logger logger = LoggerFactory.getLogger(TwilioInitializer.class);

    private final TwilioConfig twilioConfig;

    @Autowired
    public TwilioInitializer(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;

        System.out.println(twilioConfig.getAccountSid());

        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

        logger.info("Twilio Initialized");

    }
}
