package com.kamal.eCommerce.service;

import com.kamal.eCommerce.model.Order;
import com.kamal.eCommerce.model.User;
import com.kamal.eCommerce.repository.OrderRepository;
import com.kamal.eCommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for handling order operations.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Get all orders.
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Get order by its ID.
     */
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    /**
     * Create an order with the provided payment method.
     */
    public String createOrder(Long userId, double totalAmount, String paymentMethod) {
        User customer = userRepository.findById(userId).orElse(null);
        if (customer == null) {
            return "User not found!";
        }
        Order order = new Order(customer, totalAmount, paymentMethod, "Pending");
        orderRepository.save(order);
        return "Order placed successfully!";
    }

    /**
     * Delete an order by its ID.
     */
    public String deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            return "Order not found!";
        }
        orderRepository.deleteById(orderId);
        return "Order deleted!";
    }

    /**
     * Get order history for a given user.
     */
    public List<Order> getOrderHistory(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    /**
     * Confirm an order.
     */
    public String confirmOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return "Order not found!";
        }
        order.setStatus("Confirmed");
        orderRepository.save(order);
        return "Order confirmed successfully!";
    }

    /**
     * Track the status of an order.
     */
    public String trackOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return "Order not found!";
        }
        return "Order Status: " + order.getStatus();
    }
}
