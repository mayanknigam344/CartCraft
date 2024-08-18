package org.example.service.cart;

import org.example.service.decorator.PercentageCouponDecorator;
import org.example.service.decorator.TypeCouponDecorator;
import org.example.service.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> productList;

    public ShoppingCart(){
        productList = new ArrayList<>();
    }

    public void addToCart(Product product){


        Product productAfterDiscount = new TypeCouponDecorator(
                new PercentageCouponDecorator(product,10),10,product.getProductType());
        productList.add(productAfterDiscount);
    }
    public double getTotalPrice(){
        double totalPrice = 0;
        for(Product product: productList){
            totalPrice = totalPrice + product.getPrice();
        }
        return totalPrice;
    }
}
