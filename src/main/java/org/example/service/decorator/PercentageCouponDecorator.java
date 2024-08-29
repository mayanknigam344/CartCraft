package org.example.service.decorator;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.product.Product;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PercentageCouponDecorator implements CouponDecorator{

    @Override
    public ShoppingCartResponse process(ShoppingCartRequest shoppingCartRequest) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();

        var productListAndItsQuantity = shoppingCartRequest.getProductListAndItsQuantity();

        for(HashMap<Product, Integer> productIntegerHashMap : productListAndItsQuantity) {
            for (Map.Entry<Product, Integer> productIntegerEntry : productIntegerHashMap.entrySet()) {
                var product = productIntegerEntry.getKey();
                var quantity = productIntegerEntry.getValue();
                productAfterDiscountedPrice(product);
            }

            Optional.ofNullable(shoppingCartResponse)
                    .map(ShoppingCartResponse::getProductListAndItsQuantity)
                    .orElseGet(() -> {
                        List<HashMap<Product, Integer>> newList = new ArrayList<>();
                        shoppingCartResponse.setProductListAndItsQuantity(newList);
                        return newList;
                    })
                    .add(productIntegerHashMap);

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
