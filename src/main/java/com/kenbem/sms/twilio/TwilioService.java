package com.kenbem.sms.twilio;

import com.kenbem.sms.sms.SmsRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TwilioService {

    private final TwilioSmsSender smsSender;

    public void sendSms(SmsRequest request){
        smsSender.sendSms(request);
    }

}
