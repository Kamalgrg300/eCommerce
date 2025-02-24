package com.kamal.eCommerce.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Cart entity represents a shopping cart linked to a user.
 */
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    private double totalPrice;

    public Cart() {}

    public Cart(User user) {
        this.user = user;
        this.totalPrice = 0.0;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public List<CartItem> getCartItems() { return cartItems; }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
