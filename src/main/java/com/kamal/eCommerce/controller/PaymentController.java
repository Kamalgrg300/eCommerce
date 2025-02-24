package com.kamal.eCommerce.controller;

import com.kamal.eCommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for payment operations.
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * Process payment for an order.
     */
    @PostMapping("/pay")
    public String makePayment(@RequestParam Long orderId, @RequestParam String paymentMethod) {
        return paymentService.processPayment(orderId, paymentMethod);
    }

    /**
     * Get payment receipt for an order.
     */
    @GetMapping("/receipt/{orderId}")
    public String getReceipt(@PathVariable Long orderId) {
        return paymentService.getPaymentReceipt(orderId);
    }
}
