package org.example.response;

import lombok.Getter;
import lombok.Setter;
import org.example.service.product.CartProduct;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ShoppingCartResponse {
    List<HashMap<Integer, CartProduct>> cartProductLists;
    double totalFinalPrice;
}
