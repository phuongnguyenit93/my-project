package com.project.database.service;

public interface EmailService {
    public void sendEmail(String from, String to, String subject, String content,String password);
}
