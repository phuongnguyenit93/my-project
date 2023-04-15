package com.project.database.restController;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.database.service.impl.EmailServiceImpl;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    EmailServiceImpl emailService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/send-mail")
    public ResponseEntity<String> sendMail(@RequestParam(name = "password") String password) {
        emailService.sendEmail("phuongnguyenit93@gmail.com", "nguyendodinhphuong168@gmail.com", "New successfully", "New promote",password);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/send-mail-with-template")
    public ResponseEntity<String> sendMailWithTemplate(@RequestParam(name = "password") String password) throws MessagingException {
        emailService.sendEmailWithTemplate("phuongnguyenit93@gmail.com", "nguyendodinhphuong168@gmail.com", "New successfully", "New promote",password);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
