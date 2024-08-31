package org.example.service.payment;

import lombok.RequiredArgsConstructor;
import org.example.service.payment.dto.PaymentResult;
import org.example.response.ShoppingCartResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResult execute(ShoppingCartResponse shoppingCartResponse) {
        return null;
    }
}
