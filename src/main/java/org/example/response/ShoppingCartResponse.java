package org.example.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.service.product.CartProduct;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Builder
public class ShoppingCartResponse {
    List<HashMap<Integer, CartProduct>> cartProductLists;
    double totalFinalPrice;
}
