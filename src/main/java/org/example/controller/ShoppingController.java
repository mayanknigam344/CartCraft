package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.cart.ShoppingCartService;
import org.example.service.product.CartProduct;
import org.example.service.product.Category;
import org.example.service.product.Product;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ShoppingController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartResponse showCart(){
        var response = shoppingCartService.addToCart(buildShoppingCartRequest());
        double totalPrice = 0.0;
        for(HashMap<Integer, CartProduct> productIntegerHashMap : response.getCartProductLists()){
            for(Map.Entry<Integer,CartProduct> productIntegerEntry : productIntegerHashMap.entrySet()) {
                totalPrice += productIntegerEntry.getValue().getProduct().getFinalPrice() * productIntegerEntry.getValue().getQuantity();
                System.out.println(" Product " + productIntegerEntry.getKey() + " total price " + totalPrice);
            }
        }
        response.setTotalFinalPrice(totalPrice);
        return response;
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
