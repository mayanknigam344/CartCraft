package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.response.ShoppingCartResponse;
import org.example.service.product.CartProduct;
import org.example.service.product.Product;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ProductPaymentUtil {

    public Product productAfterDiscountedPrice(Product product, double discountPercentage) {
        double actualPrice;
        if(product.getFinalPrice()!=0) {
            actualPrice = product.getFinalPrice();
        }else{
            actualPrice = product.getOriginalPrice();
        }
        var price = actualPrice - (actualPrice*discountPercentage)/100;
        return product.toBuilder().finalPrice(price).build();
    }

    public double calculate(ShoppingCartResponse shoppingCartResponse) {
        double totalPrice = 0.0;
        for(HashMap<Integer, CartProduct> productIntegerHashMap : shoppingCartResponse.getCartProductLists()){
            for(Map.Entry<Integer,CartProduct> productIntegerEntry : productIntegerHashMap.entrySet()) {
                totalPrice += productIntegerEntry.getValue().getProduct().getFinalPrice() * productIntegerEntry.getValue().getQuantity();
                System.out.println(" Product " + productIntegerEntry.getKey() + " total price " + totalPrice);
            }
        }
        return totalPrice;
    }
}
