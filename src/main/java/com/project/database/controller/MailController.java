package com.project.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.database.service.EmailService;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    EmailService emailService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/send-mail")
    public ResponseEntity<String> sendMail(@RequestParam(name = "password") String password) {
        emailService.sendEmail("phuongnguyenit93@gmail.com", "nguyendodinhphuong168@gmail.com", "New successfully", "New promote",password);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
