package com.kamal.eCommerce.model;

import jakarta.persistence.*;

/**
 * Order entity represents a customer order.
 */
@Entity
@Table(name = "orders")  // Avoid using "order" as table name since it's a SQL keyword
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private double totalAmount;
    private String paymentMethod;
    private String status;

    public Order() {}

    public Order(User user, double totalAmount, String paymentMethod, String status) {
        this.user = user;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public double getTotalAmount() { return totalAmount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
