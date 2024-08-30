package org.example.support;

import lombok.Builder;
import lombok.Value;
import org.example.service.product.CartProduct;

import java.util.HashMap;
import java.util.List;

@Builder
@Value
public class ProductProcessingResult {
     List<HashMap<Integer, CartProduct>> cartProductsList;
}
