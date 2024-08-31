package org.example.service.payment.internal.strategy.cash;

import org.example.service.payment.dto.PaymentResult;
import org.example.service.payment.internal.strategy.PaymentStrategy;
import org.example.response.ShoppingCartResponse;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentResult pay(ShoppingCartResponse shoppingCartResponse) {
        return null;
    }

    @Override
    public boolean isApplicable(ShoppingCartResponse shoppingCartResponse) {
        return false;
    }
}
