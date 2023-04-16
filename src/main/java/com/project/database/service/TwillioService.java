package com.project.database.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.database.configuration.TwilioConfiguration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwillioService {
    @Autowired
    TwilioConfiguration twilioConfiguration;

    public void sendSMS(String toPhone,String message) {
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());

        Message.creator(new PhoneNumber(toPhone), new PhoneNumber(twilioConfiguration.getFromPhoneNumber()), message).create();
    }

    public void makeCall(String toPhone) throws URISyntaxException{
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());

        Call.creator(new PhoneNumber(toPhone), new PhoneNumber(twilioConfiguration.getFromPhoneNumber()), new URI("http://demo.twilio.com/docs/voice.xml")).create();
    }
}
