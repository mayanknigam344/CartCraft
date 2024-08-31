package org.example.service.payment.internal.strategy;

import org.example.service.payment.dto.PaymentResult;
import org.example.response.ShoppingCartResponse;

public interface PaymentStrategy {
    PaymentResult pay(ShoppingCartResponse shoppingCartResponse);
    boolean isApplicable(ShoppingCartResponse shoppingCartResponse);
}
