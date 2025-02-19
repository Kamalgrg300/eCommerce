package com.kamal.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kamal.eCommerce.model.*;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {}