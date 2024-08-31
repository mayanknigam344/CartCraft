package org.example.service.payment.internal;

import org.example.model.dto.ShoppingCartResponse;
import org.example.model.PaymentResult;

public interface PaymentFacade {
    PaymentResult delegatePayment(ShoppingCartResponse shoppingCartResponse);
}
