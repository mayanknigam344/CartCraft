package org.example.service.decorator;

import org.example.response.ShoppingCartResponse;
import org.example.service.product.CartProduct;
import org.example.support.ProductProcessingResult;
import org.example.util.ProductPaymentUtil;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PercentageCouponDecoratorImpl implements CouponDecorator{

    @Override
    public ShoppingCartResponse process(ProductProcessingResult productProcessingResult) {
        ShoppingCartResponse shoppingCartResponse = ShoppingCartResponse.builder().build();

        var cartProductLists = productProcessingResult.getCartProductsList();

        HashMap<Integer,CartProduct> hashMap = new HashMap<>();

        for(Map.Entry<Integer, CartProduct> cartProductHashMap : cartProductLists.entrySet()) {
            var productId = cartProductHashMap.getKey();
            var cartProduct = cartProductHashMap.getValue();
            var product = cartProduct.getProduct();
            var productAfterDiscount = ProductPaymentUtil.productAfterDiscountedPrice(product , 10.0);
            cartProduct = cartProduct.toBuilder().product(productAfterDiscount).build();
            hashMap.put(productId, cartProduct);
        }
        shoppingCartResponse = shoppingCartResponse.toBuilder().cartProductLists(hashMap).build();

        return shoppingCartResponse;
    }
}
