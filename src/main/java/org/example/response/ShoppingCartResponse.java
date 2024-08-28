package org.example.response;

import lombok.Getter;
import lombok.Setter;
import org.example.service.product.Product;

import java.util.List;

@Getter
@Setter
public class ShoppingCartResponse {
    List<Product> productList;
    double totalFinalPrice;
}
