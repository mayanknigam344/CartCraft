package org.example.service.product;

import lombok.Getter;
import lombok.Setter;

public class Product {
       String productName;
       @Getter
       ProductType productType;
       @Getter
       double originalPrice;
       @Setter
       double finalPrice;

      public Product(){}
      public Product(String productName, ProductType productType, double originalPrice) {
        this.productName = productName;
        this.productType = productType;
        this.originalPrice = originalPrice;
    }
}
