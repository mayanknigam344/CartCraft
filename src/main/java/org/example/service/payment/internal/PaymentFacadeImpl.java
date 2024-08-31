package org.example.service.payment.internal;

import lombok.RequiredArgsConstructor;
import org.example.model.PaymentResult;
import org.example.service.payment.internal.strategy.PaymentStrategy;
import org.example.model.dto.ShoppingCartResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentFacadeImpl implements PaymentFacade {

    private final List<PaymentStrategy> paymentStrategyList;

    @Override
    public PaymentResult delegatePayment(ShoppingCartResponse shoppingCartResponse) {
        return paymentStrategyList.stream()
                .filter(paymentStrategy -> paymentStrategy.isApplicable(shoppingCartResponse))
                .findFirst()
                .map(paymentStrategy -> paymentStrategy.pay(shoppingCartResponse))
                .orElseThrow();
    }
}
