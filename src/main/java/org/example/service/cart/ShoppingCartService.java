package org.example.service.cart;

import org.example.model.dto.ShoppingCartRequest;
import org.example.model.dto.ShoppingCartResponse;
import org.springframework.stereotype.Component;

@Component
public interface ShoppingCartService {
    ShoppingCartResponse addToCart(ShoppingCartRequest request);
}
