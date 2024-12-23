package com.example.Inventory_Management_System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_order")
public class Order {
    @Id
    private int orderId;
    private long productQuantity;
    private String area;
    private String society;
    private int houseNumber;
    private String city;
    private String country;
    private int pinCode;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
