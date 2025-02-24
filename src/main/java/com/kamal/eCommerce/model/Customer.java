package com.kamal.eCommerce.model;

import jakarta.persistence.Entity;

/**
 * Customer entity extends User.
 */
@Entity
public class Customer extends User {
    public Customer() {
        super();
    }

    public Customer(String name, String email, String password) {
        super(name, email, password);
    }
}
