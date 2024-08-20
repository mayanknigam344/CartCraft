package org.example.service.decorator;

import org.example.service.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PercentageCouponDecorator implements CouponDecorator{
    private static final Logger log = LoggerFactory.getLogger(PercentageCouponDecorator.class);

    @Override
    public Product process(Product product) {
        double orgPrice = product.getOriginalPrice();
        double discountedPrice = orgPrice - (orgPrice*10)/100;
        log.info("Price After percentage discount {}", discountedPrice);
        product.setFinalPrice(discountedPrice);
        return product;
    }
}
