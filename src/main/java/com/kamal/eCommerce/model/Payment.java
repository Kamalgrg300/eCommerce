package com.kamal.eCommerce.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentMethod;
    private String paymentStatus;
    
    @OneToOne
    private Order order;
    
    public Payment() {}
}
