package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.service.product.Product;

@UtilityClass
public class ProductPaymentUtil {
    public static void productAfterDiscountedPrice(Product product, double discountPercentage) {
        double actualPrice;
        if(product.getFinalPrice()!=0) {
            actualPrice = product.getFinalPrice();
        }else{
            actualPrice = product.getOriginalPrice();
        }
        var price = actualPrice - (actualPrice*discountPercentage)/100;
        product.setFinalPrice(price);
    }
}
