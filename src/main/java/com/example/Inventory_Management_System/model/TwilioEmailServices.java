package com.example.Inventory_Management_System.model;

import com.twilio.twiml.voice.Echo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class TwilioEmailServices {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String to,String subject,String text){
        try {
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(text);
         javaMailSender.send(simpleMailMessage);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
