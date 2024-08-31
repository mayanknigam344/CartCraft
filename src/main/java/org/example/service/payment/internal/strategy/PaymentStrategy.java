package org.example.service.payment.internal.strategy;

import org.example.model.PaymentResult;
import org.example.model.dto.ShoppingCartResponse;

public interface PaymentStrategy {
    PaymentResult pay(ShoppingCartResponse shoppingCartResponse);
    boolean isApplicable(ShoppingCartResponse shoppingCartResponse);
}
