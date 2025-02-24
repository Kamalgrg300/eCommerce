package com.kamal.eCommerce.service;

import com.kamal.eCommerce.model.*;
import com.kamal.eCommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Service class for handling cart operations.
 */
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    /**
     * Add a product to the user's cart.
     */
    public String addToCart(Long userId, Long productId, int quantity) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Product> productOpt = productRepository.findById(productId);

        if (userOpt.isEmpty() || productOpt.isEmpty()) {
            return "User or Product not found!";
        }

        User user = userOpt.get();
        Product product = productOpt.get();

        Cart cart = cartRepository.findByUser(user).orElse(new Cart(user));
        CartItem cartItem = new CartItem(product, quantity);
        cart.getCartItems().add(cartItem);
        cart.setTotalPrice(cart.getTotalPrice() + cartItem.getTotalPrice());

        cartRepository.save(cart);
        return "Product added to cart successfully!";
    }

    /**
     * Retrieve the cart for a given user.
     */
    public Cart getCart(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return null;
        }
        return cartRepository.findByUser(userOpt.get()).orElse(null);
    }

    /**
     * Checkout process to create an order from the cart.
     */
    public String checkout(Long userId, String paymentMethod) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return "User not found!";
        }

        User user = userOpt.get();
        Optional<Cart> cartOpt = cartRepository.findByUser(user);
        if (cartOpt.isEmpty() || cartOpt.get().getCartItems().isEmpty()) {
            return "Cart is empty!";
        }

        Cart cart = cartOpt.get();
        Order order = new Order(user, cart.getTotalPrice(), paymentMethod, "Pending");
        orderRepository.save(order);

        // Clear cart after checkout
        cart.getCartItems().clear();
        cart.setTotalPrice(0);
        cartRepository.save(cart);

        return "Checkout successful!";
    }
}
