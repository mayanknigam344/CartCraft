package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.request.ShoppingCartRequest;
import org.example.service.cart.ShoppingCartService;
import org.example.service.product.Category;
import org.example.service.product.Product;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShoppingController {

    private final ShoppingCartService shoppingCartServiceService;

    public void test(){
        var response = shoppingCartServiceService.addToCart(buildShoppingCartRequest());
        System.out.println(response);

    }


    private ShoppingCartRequest buildShoppingCartRequest(){
        ShoppingCartRequest shoppingCartRequest = new ShoppingCartRequest();
        Product product = new Product("ABC", Category.ELECTRONICS,1000);
        shoppingCartRequest.setProductList(List.of(product));
        return shoppingCartRequest;
    }
}
