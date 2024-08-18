package org.example.service.product;

public abstract class Product {

      String productName;
      ProductType productType;

      public Product(){}
      public Product(String productName, ProductType productType) {
        this.productName = productName;
        this.productType = productType;
    }

    public abstract double getPrice();

    public ProductType getProductType(){
        return productType;
    }
}
