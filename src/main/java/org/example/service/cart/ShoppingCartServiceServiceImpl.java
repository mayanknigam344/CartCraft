package org.example.service.cart;

import lombok.RequiredArgsConstructor;
import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.decorator.CouponDecorator;

import java.util.List;

@RequiredArgsConstructor
public class ShoppingCartServiceServiceImpl implements ShoppingCartService {

    List<CouponDecorator> couponDecoratorList;

    @Override
    public ShoppingCartResponse addToCart(ShoppingCartRequest request) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();
         couponDecoratorList
                .forEach(couponDecorator -> {
                    var response = couponDecorator.process(request);
                    var productsList = response.getProductListAndItsQuantity();
                    request.setProductListAndItsQuantity(productsList);
                });
         shoppingCartResponse.setProductListAndItsQuantity(request.getProductListAndItsQuantity());
        return shoppingCartResponse;
    }
}
