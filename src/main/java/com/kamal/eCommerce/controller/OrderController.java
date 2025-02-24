package com.kamal.eCommerce.controller;

import com.kamal.eCommerce.model.Order;
import com.kamal.eCommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for order operations.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Get all orders.
     */
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * Get order by ID.
     */
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    /**
     * Create an order.
     */
    @PostMapping("/create")
    public String createOrder(@RequestParam Long userId, @RequestParam double totalAmount, @RequestParam String paymentMethod) {
        return orderService.createOrder(userId, totalAmount, paymentMethod);
    }

    /**
     * Delete an order.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
    
    /**
     * Confirm an order.
     */
    @PostMapping("/confirm/{orderId}")
    public String confirmOrder(@PathVariable Long orderId) {
        return orderService.confirmOrder(orderId);
    }

    /**
     * Get order history for a user.
     */
    @GetMapping("/history/{userId}")
    public List<Order> getOrderHistory(@PathVariable Long userId) {
        return orderService.getOrderHistory(userId);
    }

    /**
     * Track the status of an order.
     */
    @GetMapping("/track/{orderId}")
    public String trackOrder(@PathVariable Long orderId) {
        return orderService.trackOrder(orderId);
    }
}
