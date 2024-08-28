package org.example.service.decorator;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;

public interface CouponDecorator {
    ShoppingCartResponse process(ShoppingCartRequest shoppingCartRequest);
}
