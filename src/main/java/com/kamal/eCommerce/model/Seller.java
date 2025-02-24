package com.kamal.eCommerce.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Seller entity extends User and represents a seller in the system.
 * It includes seller-specific properties such as a list of products.
 */
@Entity
public class Seller extends User {
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> products;

    public Seller() {
        super();
    }

    public Seller(String name, String email, String password) {
        super(name, email, password);
    }

    // Getter for products
    public List<Product> getProducts() {
        return products;
    }

    // Setter for products
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
