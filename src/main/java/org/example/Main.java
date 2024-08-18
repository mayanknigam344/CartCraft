package org.example;

import org.example.service.cart.ShoppingCart;
import org.example.service.product.Product;
import org.example.service.product.ProductType;
import org.example.service.product.items.Item1;
import org.example.service.product.items.Item2;

public class Main {
    public static void main(String[] args) {
        Product item1 = new Item1("FAN", ProductType.ELECTRONICS, 1000);
        Product item2 = new Item2("FAS", ProductType.FASHION, 2000);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(item1);
        shoppingCart.addToCart(item2);
        System.out.print(shoppingCart.getTotalPrice());
    }
}