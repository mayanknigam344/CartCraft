package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.ShoppingCartRequest;
import org.example.model.dto.ShoppingCartResponse;
import org.example.service.cart.ShoppingCartService;
import org.example.util.ProductPaymentUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoppingController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartResponse showCart(ShoppingCartRequest shoppingCartRequest){
        var response = shoppingCartService.addToCart(shoppingCartRequest);
        var totalPrice = ProductPaymentUtil.calculateTotalPrice(response);
        response = response.toBuilder().totalFinalPrice(totalPrice).build();
        return response;
    }
}
