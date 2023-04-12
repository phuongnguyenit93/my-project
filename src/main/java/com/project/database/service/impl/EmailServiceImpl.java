package com.project.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.database.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void sendEmail(String from, String to, String subject, String content,String password) {
        
        if (bCryptPasswordEncoder.matches(password, mailSender.getPassword())) {
            mailSender.setPassword(password);
        };

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        
        mailSender.send(mailMessage);
    }
    
}
