package org.example.service.decorator;

import org.example.service.product.CartProduct;
import org.example.service.product.Category;
import org.example.support.ProductProcessingResult;
import org.example.util.ProductPaymentUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class TypeCouponDecoratorImpl implements CouponDecorator{
    static List<Category> allowedCategories = new ArrayList<>();
    static{
        allowedCategories.add(Category.ELECTRONICS);
    }

    @Override
    public  ProductProcessingResult process(ProductProcessingResult input) {
        HashMap<Integer,CartProduct> discountedCartItems = new HashMap<>();

        for(var entry: input.getCartProductsList().entrySet()){
                var productId = entry.getKey();
                var cartProduct = entry.getValue();
                var product = cartProduct.getProduct();
                if(allowedCategories.contains(product.getCategory())){
                    product = ProductPaymentUtil.productAfterDiscountedPrice(product, 20.0);
                }
                cartProduct = cartProduct.toBuilder().product(product).build();
               discountedCartItems.put(productId, cartProduct);
            }
        return ProductProcessingResult.builder()
                .cartProductsList(discountedCartItems)
                .build();
    }
}
