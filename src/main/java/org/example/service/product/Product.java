package org.example.service.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
       int id;
       String productName;
       Category category;
       double originalPrice;
       double finalPrice;

      public Product(String productName, Category category, double originalPrice) {
        this.productName = productName;
        this.category = category;
        this.originalPrice = originalPrice;
    }
}
