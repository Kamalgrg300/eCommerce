package com.kamal.eCommerce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Payment entity represents payment details for an order.
 */
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Order order;
    
    private String paymentMethod; // e.g., Credit Card, Debit Card, PayPal, Gift Card
    private double amount;
    private LocalDateTime transactionDate;
    private String transactionId;
    private String status; // e.g., Pending, Successful, Failed

    public Payment() {}

    public Payment(Order order, String paymentMethod, double amount, String transactionId, String status) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.transactionId = transactionId;
        this.status = status;
        this.transactionDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Order getOrder() { return order; }
    public String getPaymentMethod() { return paymentMethod; }
    public double getAmount() { return amount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public String getTransactionId() { return transactionId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
