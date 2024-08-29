package org.example.service.decorator;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.product.CartProduct;
import org.example.service.product.Product;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PercentageCouponDecoratorImpl implements CouponDecorator{

    @Override
    public ShoppingCartResponse process(ShoppingCartRequest shoppingCartRequest) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();

        var cartProductLists = shoppingCartRequest.getCartProductLists();

        for(HashMap<Integer, CartProduct> cartProductHashMap : cartProductLists) {
            for (Map.Entry<Integer, CartProduct> productIntegerEntry : cartProductHashMap.entrySet()) {
                var product = productIntegerEntry.getValue().getProduct();
                productAfterDiscountedPrice(product);
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

    private void productAfterDiscountedPrice(Product product) {
       double actualPrice;
        if(product.getFinalPrice()!=0) {
            actualPrice = product.getFinalPrice();
        }else{
            actualPrice = product.getOriginalPrice();
        }
        var finalPrice = actualPrice - (actualPrice*10)/100;
        product.setFinalPrice(finalPrice);
    }
}
