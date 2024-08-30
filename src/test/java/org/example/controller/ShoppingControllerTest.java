package org.example.controller;


import org.example.service.cart.ShoppingCartService;
import org.example.service.cart.ShoppingCartServiceServiceImpl;
import org.example.service.decorator.PercentageCouponDecoratorImpl;
import org.example.service.decorator.TypeCouponDecoratorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class ShoppingControllerTest {

    private PercentageCouponDecoratorImpl percentageCouponDecoratorImpl;
    private TypeCouponDecoratorImpl typeCouponDecoratorImpl;
    private ShoppingCartService shoppingCartService;
    private ShoppingController shoppingController;

    @BeforeEach
    void setUp() {
         percentageCouponDecoratorImpl = new PercentageCouponDecoratorImpl();
         typeCouponDecoratorImpl = new TypeCouponDecoratorImpl();
         shoppingCartService = new ShoppingCartServiceServiceImpl(List.of(percentageCouponDecoratorImpl, typeCouponDecoratorImpl));
         shoppingController = new ShoppingController(shoppingCartService);
    }

    @Test
    void showCart(){
        // when
        var result = shoppingController.showCart();

        // then
        assertThat(result.getTotalFinalPrice()).isNotNull().isEqualTo(2340.0);

    }
}