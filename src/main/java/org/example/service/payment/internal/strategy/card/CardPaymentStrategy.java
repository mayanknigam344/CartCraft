package org.example.service.payment.internal.strategy.card;

import lombok.RequiredArgsConstructor;
import org.example.service.payment.internal.strategy.PaymentStrategy;
import org.example.service.payment.dto.PaymentResult;
import org.example.response.ShoppingCartResponse;

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
