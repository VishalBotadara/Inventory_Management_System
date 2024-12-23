package com.example.Inventory_Management_System.services;

import com.example.Inventory_Management_System.model.Product;
import com.example.Inventory_Management_System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
