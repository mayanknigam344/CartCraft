package org.example.service.payment.internal.strategy.cash;

import org.example.model.PaymentResult;
import org.example.service.payment.internal.strategy.PaymentStrategy;
import org.example.model.dto.ShoppingCartResponse;

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
