package com.example.Inventory_Management_System.services;

import jakarta.annotation.PostConstruct;
//import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class SendReports {
    @Autowired
    private JavaMailSender javaMailSender;

    @PostConstruct
    public void sendReports() {
      try{
          MimeMessage mimeMessage = javaMailSender.createMimeMessage();
          MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
          mimeMessageHelper.setTo("mohitsabhadiya123@gmail.com");
          mimeMessageHelper.setFrom("vishalbotadara2005@gmail.com");
          mimeMessageHelper.setText("It's An Your Product Reports ");
          mimeMessageHelper.setSubject("Mailing Services");

          File file = new File("C:\\Users\\leptop\\Downloads\\Inventory_Management_System\\Inventory_Management_System\\src\\main\\java\\com\\example\\Inventory_Management_System\\services\\demo.csv");
          mimeMessageHelper.addAttachment(file.getName(), file);
          javaMailSender.send(mimeMessage);
      }
      catch (Exception e){
          System.out.println(e.getMessage());
      }
    }
}


