package org.example.response;

import lombok.Getter;
import lombok.Setter;
import org.example.service.product.Product;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ShoppingCartResponse {
    List<HashMap<Product, Integer>> productListAndItsQuantity;
    double totalFinalPrice;
}
