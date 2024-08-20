package org.example.service.cart;

import org.example.service.decorator.CouponDecorator;
import org.example.service.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {

    private final List<CouponDecorator> couponDecoratorList;

    private List<Product> finalProductList = new ArrayList<>();

    public ShoppingCart(List<CouponDecorator> couponDecoratorList) {
        this.couponDecoratorList = couponDecoratorList;
    }

    public void addToCart(Product product){
       couponDecoratorList
                       .forEach(couponDecorator -> {
                           couponDecorator.process(product);
                       });
        finalProductList.add(product);
    }
}
