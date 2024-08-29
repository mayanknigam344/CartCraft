package org.example.service.cart;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.decorator.CouponDecorator;

import java.util.List;

public class ShoppingCartServiceServiceImpl implements ShoppingCartService {

    List<CouponDecorator> couponDecoratorList;

    public ShoppingCartServiceServiceImpl(List<CouponDecorator> couponDecoratorList) {
        this.couponDecoratorList = couponDecoratorList;
    }

    @Override
    public ShoppingCartResponse addToCart(ShoppingCartRequest request) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();
         couponDecoratorList
                .forEach(couponDecorator -> {
                    var response = couponDecorator.process(request);
                    var productsList = response.getCartProductLists();
                    request.setCartProductLists(productsList);
                });
         shoppingCartResponse.setCartProductLists(request.getCartProductLists());
        return shoppingCartResponse;
    }
}
