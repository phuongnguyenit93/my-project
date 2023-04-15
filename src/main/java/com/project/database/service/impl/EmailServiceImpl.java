package com.project.database.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.project.database.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SpringTemplateEngine springTemplateEngine;

    @Override
    public void sendEmail(String from, String to, String subject, String content,String password) {
        
        String oldPassword = mailSender.getPassword();

        if (bCryptPasswordEncoder.matches(password, mailSender.getPassword())) {
            mailSender.setPassword(password);
        };

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        
        mailSender.send(mailMessage);
        mailSender.setPassword(oldPassword);
    }
    
    public void sendEmailWithTemplate(String from,String to, String title, String content,String password) throws MessagingException {
        String oldPassword = mailSender.getPassword();
        
        if (bCryptPasswordEncoder.matches(password, mailSender.getPassword())) {
            mailSender.setPassword(password);
        };

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(title);

        Context context = new Context();
        context.setVariable("title", title);
        context.setVariable("content", content);

        String htmlContent = springTemplateEngine.process("email-template.html", context);
        helper.setText(htmlContent, true);

        mailSender.send(message);
        mailSender.setPassword(oldPassword);
    }
}
