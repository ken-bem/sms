package com.kenbem.sms.twilio;

import com.kenbem.sms.config.TwilioConfig;
import com.kenbem.sms.sms.SmsRequest;
import com.kenbem.sms.sms.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TwilioSmsSender implements SmsSender {

    public static final Logger logger = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfig twilioConfig;

    @Override
    public void sendSms(SmsRequest request) {

        if(isPhoneNumberValid(request.getPhoneNumber())){
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String message = request.getMessage();
            PhoneNumber to = new PhoneNumber(request.getPhoneNumber());
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();

            logger.debug("Sms sent to {}, message {}", request.getPhoneNumber(), request.getMessage());

        }else {
            logger.error("Wrong Phone Number");
        }


    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        //Todo: implement number validator
        return true;
    }
}
