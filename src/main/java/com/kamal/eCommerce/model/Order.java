package com.kamal.eCommerce.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAmount;

    @ManyToOne
    private Customer customer;
    
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    
    public Order() {}
}