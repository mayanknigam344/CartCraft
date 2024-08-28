package org.example.service.cart;

import org.example.request.ShoppingCartRequest;
import org.example.response.ShoppingCartResponse;
import org.springframework.stereotype.Component;

@Component
public interface ShoppingCartService {
    ShoppingCartResponse addToCart(ShoppingCartRequest request);
}
