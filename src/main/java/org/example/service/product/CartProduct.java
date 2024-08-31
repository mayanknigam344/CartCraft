package org.example.service.product;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
public class CartProduct {
    Product product;
    int quantity;
}
