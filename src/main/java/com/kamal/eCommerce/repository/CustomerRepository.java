package com.kamal.eCommerce.repository;

import com.kamal.eCommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Customer entity.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
