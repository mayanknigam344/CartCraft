package org.example.service.decorator;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.product.Product;
import org.springframework.stereotype.Component;

@Component
public class PercentageCouponDecorator implements CouponDecorator{

    @Override
    public ShoppingCartResponse process(ShoppingCartRequest shoppingCartRequest) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();
        var products = shoppingCartRequest.getProductList();
        for(var product : products){
            productAfterDiscountedPrice(product);
            shoppingCartResponse.getProductList().add(product);
        }
        return shoppingCartResponse;
    }

    private void productAfterDiscountedPrice(Product product) {
        var originalPrice = product.getOriginalPrice();
        var finalPrice = originalPrice - (originalPrice*10)/100;
        product.setFinalPrice(finalPrice);
    }
}
