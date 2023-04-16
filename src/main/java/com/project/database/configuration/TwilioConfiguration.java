package com.project.database.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@PropertySource(value = {"classpath:twilio.properties"})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TwilioConfiguration {
    private String accountSid;
    private String authToken;
    private String fromPhoneNumber;
}
