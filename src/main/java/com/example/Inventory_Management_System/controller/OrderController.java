package com.example.Inventory_Management_System.controller;

import com.example.Inventory_Management_System.model.Order;
import com.example.Inventory_Management_System.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @PostMapping("saveOrder")
    public String saveOrder(@RequestBody Order order) {
        if (orderServices.makePayment()) {
            orderServices.saveOrder(order);
            return "sucess";
        }
        else {
            return "payment failed";
        }
    }
}
