package org.example.service.decorator;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.product.Category;
import org.example.service.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TypeCouponDecorator implements CouponDecorator{
    static List<Category> typeList = new ArrayList<>();
    static{
        typeList.add(Category.ELECTRONICS);
    }

    @Override
    public ShoppingCartResponse process(ShoppingCartRequest shoppingCartRequest) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();

        var productListAndItsQuantity = shoppingCartRequest.getProductListAndItsQuantity();

        for(HashMap<Product,Integer> productIntegerHashMap : productListAndItsQuantity){
            for(Map.Entry<Product,Integer> productIntegerEntry : productIntegerHashMap.entrySet()){
                var product = productIntegerEntry.getKey();
                var quantity = productIntegerEntry.getValue();
                if(typeList.contains(product.getCategory())){
                    productAfterDiscountedPrice(product,quantity);
                }
            }
            shoppingCartResponse.getProductListAndItsQuantity().add(productIntegerHashMap);
        }
        return shoppingCartResponse;
    }

    private void productAfterDiscountedPrice(Product product, int quantity) {
        var originalPrice = product.getOriginalPrice();
        var finalPrice = originalPrice - (originalPrice*20)/100;
        product.setFinalPrice(quantity * finalPrice);
    }
}
