package org.example.support;

import lombok.Builder;
import lombok.Value;
import org.example.service.product.CartProduct;

import java.util.HashMap;

@Builder
@Value
public class ProductProcessingResult {
     // Integer- ProductId
     HashMap<Integer, CartProduct> cartProductsList;
}
