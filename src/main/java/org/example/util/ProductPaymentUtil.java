package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.model.dto.ShoppingCartResponse;
import org.example.service.product.CartProduct;
import org.example.service.product.Product;

import java.util.Map;

@UtilityClass
public class ProductPaymentUtil {

    public Product productAfterDiscountedPrice(Product product, double discountPercentage) {
        double actualPrice = 0.0;
        if(product.getFinalPrice()!=0) {
            actualPrice = product.getFinalPrice();
        }else{
            actualPrice = product.getOriginalPrice();
        }
        var price = actualPrice - (actualPrice*discountPercentage)/100;
        return product.toBuilder().finalPrice(price).build();
    }

    public double calculate(ShoppingCartResponse shoppingCartResponse) {
        double finalPrice = 0.0;
        double totalPrice = 0.0;
        for(Map.Entry<Integer, CartProduct> productIntegerHashMap : shoppingCartResponse.getCartProductLists().entrySet()){
            finalPrice = productIntegerHashMap.getValue().getProduct().getFinalPrice() * productIntegerHashMap.getValue().getQuantity();
            totalPrice+= productIntegerHashMap.getValue().getProduct().getFinalPrice() * productIntegerHashMap.getValue().getQuantity();
            System.out.println(" Product " + productIntegerHashMap.getKey() + " total price " + finalPrice);
        }
        return totalPrice;
    }
}
