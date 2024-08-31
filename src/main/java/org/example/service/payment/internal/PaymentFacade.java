package org.example.service.payment.internal;

import org.example.response.ShoppingCartResponse;
import org.example.service.payment.dto.PaymentResult;

public interface PaymentFacade {
    PaymentResult delegatePayment(ShoppingCartResponse shoppingCartResponse);
}
