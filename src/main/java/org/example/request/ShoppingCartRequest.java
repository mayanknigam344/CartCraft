package org.example.request;

import lombok.Getter;
import lombok.Setter;
import org.example.service.product.Product;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ShoppingCartRequest {

    // Product and its number of items count
    List<HashMap<Product, Integer>> productListAndItsQuantity;
}
