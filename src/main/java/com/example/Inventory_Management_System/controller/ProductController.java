package com.example.Inventory_Management_System.controller;

import com.example.Inventory_Management_System.model.Product;
import com.example.Inventory_Management_System.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @PostMapping("/saveProduct")
    public void saveProduct(@RequestBody Product product){
        productServices.saveProduct(product);
    }

}
