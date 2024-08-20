package org.example.service.decorator;

import org.example.service.product.Product;

public interface CouponDecorator {
    Product process(Product product);
}
