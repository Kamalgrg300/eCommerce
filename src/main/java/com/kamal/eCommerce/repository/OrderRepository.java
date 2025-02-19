package com.kamal.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kamal.eCommerce.model.*;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}