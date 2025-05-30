package org.example.service.payment.internal.strategy.card;

import lombok.RequiredArgsConstructor;
import org.example.service.payment.internal.strategy.PaymentStrategy;
import org.example.model.PaymentResult;
import org.example.model.dto.ShoppingCartResponse;

@RequiredArgsConstructor
public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentResult pay(ShoppingCartResponse shoppingCartResponse) {
        return null;
    }

    @Override
    public boolean isApplicable(ShoppingCartResponse shoppingCartResponse) {
        return false;
    }
}
