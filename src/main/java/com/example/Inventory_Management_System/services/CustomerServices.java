package com.example.Inventory_Management_System.services;

import com.example.Inventory_Management_System.model.Customer;
import com.example.Inventory_Management_System.model.TwilioSMS;
import com.example.Inventory_Management_System.model.TwilioWhatsapp;
import com.example.Inventory_Management_System.repository.CustomerRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TwilioSMS twilioSMS;
    @Autowired
    private TwilioWhatsapp twilioWhatsapp;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void sendSMS(Customer customer) {
     Message.creator(new PhoneNumber("+91" + customer.getCustomerMobileNumber()), new PhoneNumber(twilioSMS.getTwilioPhoneNumber()), "Order Placed").create();
    }
    public void sendSMSForWhatsapp(Customer customer){
        Message.creator(new PhoneNumber("whatsapp:+91"+customer.getCustomerMobileNumber()),new PhoneNumber(twilioWhatsapp.getTwilioPhoneNumber()),"Order Placed").create();
    }
}
