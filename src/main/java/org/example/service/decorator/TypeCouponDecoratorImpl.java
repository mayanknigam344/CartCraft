package org.example.service.decorator;

import org.example.response.ShoppingCartResponse;
import org.example.service.product.CartProduct;
import org.example.service.product.Category;
import org.example.support.ProductProcessingResult;
import org.example.util.ProductPaymentUtil;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TypeCouponDecoratorImpl implements CouponDecorator{
    static List<Category> typeList = new ArrayList<>();
    static{
        typeList.add(Category.ELECTRONICS);
    }

    @Override
    public ShoppingCartResponse process(ProductProcessingResult productProcessingResult) {
        ShoppingCartResponse shoppingCartResponse = ShoppingCartResponse.builder().build();

        var cartProductLists = productProcessingResult.getCartProductsList();

        for(HashMap<Integer, CartProduct> cartProductHashMap : cartProductLists){
            for(Map.Entry<Integer,CartProduct> productIntegerEntry : cartProductHashMap.entrySet()){
                var product = productIntegerEntry.getValue().getProduct();

                if(typeList.contains(product.getCategory())){
                    ProductPaymentUtil.productAfterDiscountedPrice(product, 20.0);
                }
            }
            Optional.of(shoppingCartResponse)
                    .map(ShoppingCartResponse::getCartProductLists)
                    .orElseGet(() -> {
                        List<HashMap<Integer, CartProduct>> newList = new ArrayList<>();
                        shoppingCartResponse.setCartProductLists(newList);
                        return newList;
                    })
                    .add(cartProductHashMap);

        }
        return shoppingCartResponse;
    }
}
