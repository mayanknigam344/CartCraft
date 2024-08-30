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

        for(HashMap<Integer, CartProduct> cartProductHashMap : cartProductLists) {
            for (Map.Entry<Integer, CartProduct> productIntegerEntry : cartProductHashMap.entrySet()) {
                var product = productIntegerEntry.getValue().getProduct();
                ProductPaymentUtil.productAfterDiscountedPrice(product , 10.0);
            }

            Optional.of(shoppingCartResponse)
                    .map(ShoppingCartResponse::getCartProductLists)
                    .orElseGet(() -> {
                        List<HashMap<Integer, CartProduct>> newList = new ArrayList<>();
                        shoppingCartResponse.setCartProductLists(newList);
                        return newList;
                    })
                    .add(cartProductHashMap);

        }
        return shoppingCartResponse;
    }
}
