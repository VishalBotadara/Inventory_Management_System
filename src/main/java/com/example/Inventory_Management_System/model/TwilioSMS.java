package com.example.Inventory_Management_System.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "twilio")
public class TwilioSMS {
    private String accountSid;
    private String authToken;
    private String twilioPhoneNumber;

}
