package org.example.service.decorator;

import org.example.response.ShoppingCartResponse;
import org.example.support.ProductAmountProcessingResult;

public interface CouponDecorator {
    ShoppingCartResponse process(ProductAmountProcessingResult productAmountProcessingResult);
}
