package com.project.database.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class I18nServiceImpl {
    @Autowired
    private MessageSource messageSource;
    
    public String getHelloString(Locale locale, String name, String mess) {
        return messageSource.getMessage("greeting.message", new Object[]{name,mess} , locale);
    }
}
