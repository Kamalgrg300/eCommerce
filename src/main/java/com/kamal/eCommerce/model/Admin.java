package com.kamal.eCommerce.model;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {
    public Admin() {}

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }
}
