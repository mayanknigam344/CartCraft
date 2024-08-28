package org.example.request;

import lombok.Getter;
import lombok.Setter;
import org.example.service.product.Product;

import java.util.List;

@Getter
@Setter
public class ShoppingCartRequest {
    List<Product> productList;
}
