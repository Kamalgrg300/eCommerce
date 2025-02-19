package com.kamal.eCommerce.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Seller seller; // Link product to a seller

    public Product() {}

    public Product(String name, double price, String description, Category category, Seller seller) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.seller = seller;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
    public Seller getSeller() { return seller; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(Category category) { this.category = category; }
    public void setSeller(Seller seller) { this.seller = seller; }
}
