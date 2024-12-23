package com.example.Inventory_Management_System;

import com.example.Inventory_Management_System.model.Product;
import com.example.Inventory_Management_System.model.TwilioSMS;
import com.example.Inventory_Management_System.repository.CustomerRepository;
import com.example.Inventory_Management_System.repository.ProductRepository;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;

@SpringBootApplication
public class InventoryManagementSystemApplication {
    @Autowired
    private TwilioSMS twilioSMS;

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementSystemApplication.class, args);
    }

    @PostConstruct
    public void initialization() {
        Twilio.init(twilioSMS.getAccountSid(), twilioSMS.getAuthToken());
    }

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void makeCsv(){
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\leptop\\Downloads\\Inventory_Management_System\\Inventory_Management_System\\src\\main\\java\\com\\example\\Inventory_Management_System\\services\\demo.csv");
             ICsvBeanWriter iCsvBeanWriter = new CsvBeanWriter(fileWriter, CsvPreference.STANDARD_PREFERENCE);) {

            String headers[] = {"productId", "productName", "productStock", "productPrice", "gst"};
            iCsvBeanWriter.writeHeader(headers);

            for (Product product : productRepository.findAll()) {
                iCsvBeanWriter.write(product, headers);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
