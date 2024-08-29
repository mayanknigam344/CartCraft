package org.example.service.decorator;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.product.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
                productAfterDiscountedPrice(product, quantity);
            }
            shoppingCartResponse.getProductListAndItsQuantity().add(productIntegerHashMap);
        }
        return shoppingCartResponse;
    }

    private void productAfterDiscountedPrice(Product product, int quantity) {
        var originalPrice = product.getOriginalPrice();
        var finalPrice = originalPrice - (originalPrice*10)/100;
        product.setFinalPrice(quantity * finalPrice);
    }
}
