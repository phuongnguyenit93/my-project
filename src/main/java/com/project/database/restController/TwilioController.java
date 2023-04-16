package com.project.database.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.database.service.TwillioService;

@RestController
@RequestMapping("/twilio")
public class TwilioController {
    @Autowired
    TwillioService twillioService;

    @GetMapping("/sendSMS")
    public ResponseEntity<String> sendTwilioSMS() {
        try {
            twillioService.sendSMS("+84938159116", "Hello Mr Phuong from twilio");
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Send failed");
        }
    }

    @GetMapping("/call")
    public ResponseEntity<String> callTwilio() {
        try {
            twillioService.makeCall("+84938159116");
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Call failed");
        }
    }
}
