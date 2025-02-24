package com.kamal.eCommerce.service;

import com.kamal.eCommerce.model.Order;
import com.kamal.eCommerce.model.Payment;
import com.kamal.eCommerce.repository.OrderRepository;
import com.kamal.eCommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * Service class for handling payment operations.
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;

    /**
     * Process payment for an order.
     */
    public String processPayment(Long orderId, String paymentMethod) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return "Order not found!";
        }
        if (!isValidPaymentMethod(paymentMethod)) {
            return "Invalid payment method! Choose from Credit Card, Debit Card, PayPal, or Gift Card.";
        }
        String transactionId = UUID.randomUUID().toString();
        Payment payment = new Payment(order, paymentMethod, order.getTotalAmount(), transactionId, "Successful");
        paymentRepository.save(payment);
        return "Payment successful! Transaction ID: " + transactionId;
    }

    /**
     * Get payment receipt for an order.
     */
    public String getPaymentReceipt(Long orderId) {
        List<Payment> payments = paymentRepository.findByOrderId(orderId);
        if (payments.isEmpty()) {
            return "No payments found for this order!";
        }
        Payment payment = payments.get(0); // Assuming one payment per order
        return "Receipt:\n" +
               "Order ID: " + orderId + "\n" +
               "Payment Method: " + payment.getPaymentMethod() + "\n" +
               "Amount: $" + payment.getAmount() + "\n" +
               "Transaction ID: " + payment.getTransactionId() + "\n" +
               "Date: " + payment.getTransactionDate() + "\n" +
               "Status: " + payment.getStatus();
    }

    /**
     * Validate if the payment method is allowed.
     */
    private boolean isValidPaymentMethod(String method) {
        return method.equalsIgnoreCase("Credit Card") ||
               method.equalsIgnoreCase("Debit Card") ||
               method.equalsIgnoreCase("PayPal") ||
               method.equalsIgnoreCase("Gift Card");
    }
}
