package com.example.Inventory_Management_System.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Collate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.function.BinaryOperator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    private String customerName;
    private long customerMobileNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> productList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Bill> billList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orderList;

    public Customer(int customerId) {
        this.customerId = customerId;
    }
}

