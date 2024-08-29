package org.example.request;

import lombok.Getter;
import lombok.Setter;
import org.example.service.product.CartProduct;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ShoppingCartRequest {

    // Product Id vs Product and its quantity
    List<HashMap<Integer, CartProduct>> cartProductLists;
}
