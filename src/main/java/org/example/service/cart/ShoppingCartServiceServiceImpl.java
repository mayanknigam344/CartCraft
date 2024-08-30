package org.example.service.cart;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.decorator.CouponDecorator;
import org.example.support.ProductProcessingResult;

import java.util.List;

public class ShoppingCartServiceServiceImpl implements ShoppingCartService {

    List<CouponDecorator> couponDecoratorList;

    public ShoppingCartServiceServiceImpl(List<CouponDecorator> couponDecoratorList) {
        this.couponDecoratorList = couponDecoratorList;
    }

    @Override
    public ShoppingCartResponse addToCart(ShoppingCartRequest request) {
        ShoppingCartResponse.ShoppingCartResponseBuilder shoppingCartResponseBuilder = ShoppingCartResponse.builder();
        var cartProducts = request.getCartProductLists();

        ProductProcessingResult productProcessingResult =
                ProductProcessingResult.builder().cartProductsList(cartProducts).build();

        for(CouponDecorator couponDecorator : couponDecoratorList) {
            var response = couponDecorator.process(productProcessingResult);
            productProcessingResult = ProductProcessingResult.builder().cartProductsList(response.getCartProductLists()).build();
        }

        shoppingCartResponseBuilder.cartProductLists(productProcessingResult.getCartProductsList());

        return shoppingCartResponseBuilder.build();
    }
}
