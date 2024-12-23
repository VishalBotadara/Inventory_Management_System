package com.example.Inventory_Management_System.repository;

import com.example.Inventory_Management_System.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {
}
