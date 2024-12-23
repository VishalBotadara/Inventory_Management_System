package com.example.Inventory_Management_System.services;

import com.example.Inventory_Management_System.model.*;
import com.example.Inventory_Management_System.repository.BillRepository;
import com.example.Inventory_Management_System.repository.CustomerRepository;
import com.example.Inventory_Management_System.repository.OrderRepository;
import com.example.Inventory_Management_System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private TwilioEmailServices twilioEmailServices;

    public boolean makePayment() {
        return new Random().nextBoolean();
    }

    public String saveOrder(Order order) {
        Product product = productRepository.findById(order.getProduct().getProductId()).get();
        if(product.getProductStock()<100){
          twilioEmailServices.sendEmail("ajaysinhsarvaiya1111@gmail.com","quantity manage","Order Will Placed");
        }
        if (makePayment()) {

            if(product.getProductStock()>0) {
                Bill bill = new Bill();
                bill.setPrice(product.getProductPrice() * order.getProductQuantity());
                product.setProductStock(product.getProductStock() - order.getProductQuantity());
                bill.setGst(product.getGst());

                double totalPrice=product.getProductPrice()*order.getProductQuantity();
                double GstAmmout=totalPrice*product.getGst()/100;
                bill.setFinalPrice(totalPrice+GstAmmout);

                Customer customer = customerRepository.findById(order.getCustomer().getCustomerId()).get();
                bill.setCustomer(customer);
                bill.setProduct(order.getProduct());

                orderRepository.save(order);
                customerServices.sendSMS(customer);
                customerServices.sendSMSForWhatsapp(customer);
                productRepository.save(product);
                customerRepository.save(customer);
                billRepository.save(bill);
                return "order success";
            }else {
                return "stock is empty";
            }
        }
        else {
            return "payment failed";
        }

    }

}
