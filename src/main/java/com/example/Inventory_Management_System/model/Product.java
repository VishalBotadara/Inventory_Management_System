package com.example.Inventory_Management_System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_product")
public class Product {
    @Id
    @Column(name = "product_id")
    private int productId;
    private String productName;
    private long productStock;
    private double productPrice;
    private double gst;

    public Product(int productId) {
        this.productId = productId;
    }

    @ManyToMany(mappedBy = "productList",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Customer> customerList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Bill> billList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> orderList;

}
