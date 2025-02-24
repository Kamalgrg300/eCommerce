package com.kamal.eCommerce.controller;

import com.kamal.eCommerce.model.Cart;
import com.kamal.eCommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for cart operations.
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * Add a product to the cart.
     */
    @PostMapping("/add")
    public String addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addToCart(userId, productId, quantity);
    }

    /**
     * Retrieve the cart for a user.
     */
    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return cartService.getCart(userId);
    }

    /**
     * Checkout the cart.
     */
    @PostMapping("/checkout")
    public String checkout(@RequestParam Long userId, @RequestParam String paymentMethod) {
        return cartService.checkout(userId, paymentMethod);
    }
}
