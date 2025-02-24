package com.kamal.eCommerce.repository;

import com.kamal.eCommerce.model.Cart;
import com.kamal.eCommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repository for Cart entity.
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
