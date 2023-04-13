package com.project.database.restController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.database.service.impl.I18nServiceImpl;

@RestController
@RequestMapping("/i18n")
public class I18nController {
    
    @Autowired
    I18nServiceImpl i18nServiceImpl;
    
    @GetMapping("/hello")
    public void getHelloMess() {
        System.out.println(i18nServiceImpl.getHelloString(Locale.FRANCE, "Phương", "Java Spring Boot"));
        System.out.println(i18nServiceImpl.getHelloString(Locale.US, "Phương", "Java Spring Boot"));
        System.out.println(i18nServiceImpl.getHelloString(new Locale("vi","VN"), "Phương", "Java Spring Boot"));
    }
}
