package com.kenbem.sms.controller;

import com.github.javafaker.Faker;
import com.kenbem.sms.sms.SmsRequest;
import com.kenbem.sms.twilio.TwilioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/sms")
@AllArgsConstructor
public class Controller {

    private final TwilioService twilioService;

    @PostMapping
    public void sendSms(@RequestBody SmsRequest request){
       // SmsRequest request = new SmsRequest(phone, faker().shakespeare().kingRichardIIIQuote());
        request.setMessage(faker().shakespeare().kingRichardIIIQuote());
        twilioService.sendSms(request);
    }

    private Faker faker(){
        return Faker.instance();
    }

}
