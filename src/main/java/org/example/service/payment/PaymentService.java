package org.example.service.payment;

import org.example.model.PaymentResult;
import org.example.model.dto.ShoppingCartResponse;

public interface PaymentService {
    PaymentResult execute(ShoppingCartResponse shoppingCartResponse);
}
