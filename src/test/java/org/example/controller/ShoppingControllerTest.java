package org.example.controller;

import org.example.request.ShoppingCartRequest;
import org.example.service.cart.ShoppingCartService;
import org.example.service.cart.ShoppingCartServiceServiceImpl;
import org.example.service.decorator.PercentageCouponDecoratorImpl;
import org.example.service.decorator.TypeCouponDecoratorImpl;
import org.example.service.product.CartProduct;
import org.example.service.product.Category;
import org.example.service.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
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
        var result = shoppingController.showCart(buildShoppingCartRequest());

        // then
        assertThat(result.getTotalFinalPrice()).isNotNull().isEqualTo(2340.0);

    }
    private ShoppingCartRequest buildShoppingCartRequest(){
        ShoppingCartRequest shoppingCartRequest = new ShoppingCartRequest();
        var product1 = Product.builder().id(1).productName("ABC").category(Category.ELECTRONICS).originalPrice(1000).build();
        var product2 = Product.builder().id(2).productName("SDC").category(Category.FASHION).originalPrice(1000).build();
        var cartProduct1 = CartProduct.builder().product(product1).quantity(2).build();
        var cartProduct2 = CartProduct.builder().product(product2).quantity(1).build();
        HashMap<Integer,CartProduct> cartProductHashMap = new HashMap<>();
        cartProductHashMap.put(1,cartProduct1);
        cartProductHashMap.put(2,cartProduct2);
        shoppingCartRequest.setCartProductLists(List.of(cartProductHashMap));
        return shoppingCartRequest;
    }
}