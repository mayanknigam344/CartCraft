package org.example.service.payment;

import org.example.service.payment.dto.PaymentResult;
import org.example.response.ShoppingCartResponse;

public interface PaymentService {
    PaymentResult execute(ShoppingCartResponse shoppingCartResponse);
}
