package org.example.service.decorator;

import org.example.service.product.CartProduct;
import org.example.support.ProductProcessingResult;
import org.example.util.ProductPaymentUtil;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PercentageCouponDecoratorImpl implements CouponDecorator{

    @Override
    public ProductProcessingResult process(ProductProcessingResult input) {
        HashMap<Integer,CartProduct> discountedCartItems = new HashMap<>();

        for(var entry : input.getCartProductsList().entrySet()) {
            var productId = entry.getKey();
            var cartProduct = entry.getValue();
            var product = cartProduct.getProduct();
            var discounted = ProductPaymentUtil.productAfterDiscountedPrice(product , 10.0);
            cartProduct = cartProduct.toBuilder().product(discounted).build();
            discountedCartItems.put(productId, cartProduct);
        }

        return ProductProcessingResult.builder()
                .cartProductsList(discountedCartItems)
                .build();
    }
}
