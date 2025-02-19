package com.kamal.eCommerce.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Order order;
    
    @ManyToOne
    private Product product;
    
    private int quantity;
    
    public OrderItem() {}
}