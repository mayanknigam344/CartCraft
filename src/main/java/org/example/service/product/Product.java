package org.example.service.product;

import lombok.Getter;
import lombok.Setter;

public class Product {
       String productName;
       @Getter
       Category category;
       @Getter
       double originalPrice;
       @Setter
       double finalPrice;

      public Product(){}
      public Product(String productName, Category category, double originalPrice) {
        this.productName = productName;
        this.category = category;
        this.originalPrice = originalPrice;
    }
}
