package com.kamal.eCommerce.model;

import jakarta.persistence.Entity;

/**
 * Admin entity extends User for admin-specific functionality.
 */
@Entity
public class Admin extends User {
    public Admin() {
        super();
    }

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }
}
