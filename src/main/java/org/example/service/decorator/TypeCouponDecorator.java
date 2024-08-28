package org.example.service.decorator;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.product.Category;
import org.example.service.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeCouponDecorator implements CouponDecorator{
    static List<Category> typeList = new ArrayList<>();
    static{
        typeList.add(Category.ELECTRONICS);
    }

    @Override
    public ShoppingCartResponse process(ShoppingCartRequest shoppingCartRequest) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();
        var products = shoppingCartRequest.getProductList();
        for(var product : products){
            if(typeList.contains(product.getCategory())) {
                productAfterDiscountedPrice(product);
            }
            shoppingCartResponse.getProductList().add(product);
        }
        return shoppingCartResponse;
    }

    private void productAfterDiscountedPrice(Product product) {
        var originalPrice = product.getOriginalPrice();
        var finalPrice = originalPrice - (originalPrice*20)/100;
        product.setFinalPrice(finalPrice);
    }
}
