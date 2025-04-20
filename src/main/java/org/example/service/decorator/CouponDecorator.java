package org.example.service.decorator;

import org.example.model.dto.ShoppingCartRequest;
import org.example.support.ProductProcessingResult;

public interface CouponDecorator {
    ProductProcessingResult process(ProductProcessingResult productProcessingResult);
    boolean isApplicable(ShoppingCartRequest request);
}
