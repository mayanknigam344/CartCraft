package org.example.service.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartProduct {
    Product product;
    int quantity;
}
