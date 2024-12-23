package com.example.Inventory_Management_System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billId;
    private double gst;
    private double price;
    private double finalPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}


