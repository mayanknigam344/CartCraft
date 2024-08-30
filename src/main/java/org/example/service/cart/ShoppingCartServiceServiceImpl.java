package org.example.service.cart;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.decorator.CouponDecorator;
import org.example.support.ProductAmountProcessingResult;

import java.util.List;

public class ShoppingCartServiceServiceImpl implements ShoppingCartService {

    List<CouponDecorator> couponDecoratorList;

    public ShoppingCartServiceServiceImpl(List<CouponDecorator> couponDecoratorList) {
        this.couponDecoratorList = couponDecoratorList;
    }

    @Override
    public ShoppingCartResponse addToCart(ShoppingCartRequest request) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();
        var cartProducts = request.getCartProductLists();

        ProductAmountProcessingResult productAmountProcessingResult =
                ProductAmountProcessingResult.builder().cartProductsList(cartProducts).build();

        for(CouponDecorator couponDecorator : couponDecoratorList) {
            var response = couponDecorator.process(productAmountProcessingResult);
            productAmountProcessingResult = ProductAmountProcessingResult.builder().cartProductsList(response.getCartProductLists()).build();
        }

        shoppingCartResponse.setCartProductLists(productAmountProcessingResult.getCartProductsList());
        return shoppingCartResponse;
    }
}
