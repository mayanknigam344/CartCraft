package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.example.service.cart.ShoppingCartService;
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
        for(HashMap<Product,Integer> productIntegerHashMap : response.getProductListAndItsQuantity()){
            for(Map.Entry<Product,Integer> productIntegerEntry : productIntegerHashMap.entrySet()){
                 totalPrice+= productIntegerEntry.getKey().getFinalPrice() * productIntegerEntry.getValue();
            }
        }
        response.setTotalFinalPrice(totalPrice);
        return response;
    }

    private ShoppingCartRequest buildShoppingCartRequest(){
        ShoppingCartRequest shoppingCartRequest = new ShoppingCartRequest();
        Product product = new Product("ABC", Category.ELECTRONICS,1000);
        HashMap<Product,Integer> productVsItsCount = new HashMap<>();
        productVsItsCount.put(product,2);
        shoppingCartRequest.setProductListAndItsQuantity(List.of(productVsItsCount));
        return shoppingCartRequest;
    }
}
