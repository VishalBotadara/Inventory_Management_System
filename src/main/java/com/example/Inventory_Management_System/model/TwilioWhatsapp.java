package com.example.Inventory_Management_System.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "twilio.whatsapp")
public class TwilioWhatsapp {

    private String twilioPhoneNumber;


}
