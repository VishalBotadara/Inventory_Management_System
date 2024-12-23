package com.example.Inventory_Management_System.controller;

import com.example.Inventory_Management_System.model.Customer;
import com.example.Inventory_Management_System.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/saveCustomer")
    public void saveProduct(@RequestBody Customer customer){
        customerServices.saveCustomer(customer);
    }
}
