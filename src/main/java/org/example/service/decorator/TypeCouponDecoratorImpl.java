package org.example.service.decorator;

import org.example.response.ShoppingCartResponse;
import org.example.service.product.CartProduct;
import org.example.service.product.Category;
import org.example.support.ProductProcessingResult;
import org.example.util.ProductPaymentUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        HashMap<Integer,CartProduct> hashMap = new HashMap<>();

        for(Map.Entry<Integer, CartProduct> cartProductHashMap : cartProductLists.entrySet()){
                var productId = cartProductHashMap.getKey();
                var cartProduct = cartProductHashMap.getValue();
                var product = cartProduct.getProduct();

                if(typeList.contains(product.getCategory())){
                    product = ProductPaymentUtil.productAfterDiscountedPrice(product, 20.0);
                }
                cartProduct = cartProduct.toBuilder().product(product).build();
               hashMap.put(productId, cartProduct);
            }
        shoppingCartResponse = shoppingCartResponse.toBuilder().cartProductLists(hashMap).build();
        return shoppingCartResponse;
    }
}
