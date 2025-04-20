package org.example.service.decorator;

import org.example.support.ProductProcessingResult;

public interface CouponDecorator {
    ProductProcessingResult process(ProductProcessingResult productProcessingResult);
}
