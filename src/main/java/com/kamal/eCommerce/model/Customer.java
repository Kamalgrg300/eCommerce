package com.kamal.eCommerce.model;

import jakarta.persistence.Entity;

@Entity
public class Customer extends User {
    public Customer() {}

    public Customer(String name, String email, String password) {
        super(name, email, password);
    }
}
