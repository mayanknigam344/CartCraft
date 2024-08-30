package org.example.service.decorator;

import org.example.response.ShoppingCartResponse;
import org.example.support.ProductProcessingResult;

public interface CouponDecorator {
    ShoppingCartResponse process(ProductProcessingResult productProcessingResult);
}
