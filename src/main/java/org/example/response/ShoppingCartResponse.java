package org.example.response;

import lombok.Builder;
import lombok.Getter;
import org.example.service.product.CartProduct;

import java.util.HashMap;

@Getter
@Builder(toBuilder = true)
public class ShoppingCartResponse {
    HashMap<Integer, CartProduct> cartProductLists;
    double totalFinalPrice;
}
