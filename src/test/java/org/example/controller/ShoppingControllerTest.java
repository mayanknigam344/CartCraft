package org.example.controller;


import org.example.service.cart.ShoppingCartService;
import org.example.service.cart.ShoppingCartServiceServiceImpl;
import org.example.service.decorator.PercentageCouponDecorator;
import org.example.service.decorator.TypeCouponDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class ShoppingControllerTest {

    private PercentageCouponDecorator percentageCouponDecorator;
    private TypeCouponDecorator typeCouponDecorator;
    private ShoppingCartService shoppingCartService;
    private ShoppingController shoppingController;

    @BeforeEach
    void setUp() {
         percentageCouponDecorator = new PercentageCouponDecorator();
         typeCouponDecorator = new TypeCouponDecorator();
         shoppingCartService = new ShoppingCartServiceServiceImpl(List.of(percentageCouponDecorator,typeCouponDecorator));
         shoppingController = new ShoppingController(shoppingCartService);
    }

    @Test
    void showCart(){
        // when
        var result = shoppingController.showCart();

        // then
        assertThat(result.getTotalFinalPrice()).isNotNull().isEqualTo(1440.0);

    }
}