package org.example;

import org.example.service.cart.ShoppingCart;
import org.example.service.decorator.PercentageCouponDecorator;
import org.example.service.decorator.TypeCouponDecorator;
import org.example.service.product.Product;
import org.example.service.product.ProductType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product item1 = new Product("FAN", ProductType.ELECTRONICS, 1000);

        //TODO: Will enable this later
        //Product item2 = new Product("FAS", ProductType.FASHION, 2000);

        ShoppingCart shoppingCart = new ShoppingCart(
                List.of(new PercentageCouponDecorator(),
                        new TypeCouponDecorator()));
        shoppingCart.addToCart(item1);

        //shoppingCart.addToCart(item2);
       /* System.out.print(shoppingCart.getTotalPrice());*/
    }
}