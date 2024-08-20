package org.example.service.product;

public class Product {
       String productName;
       ProductType productType;
       double originalPrice;
       double finalPrice;

      public Product(){}
      public Product(String productName, ProductType productType, double originalPrice) {
        this.productName = productName;
        this.productType = productType;
        this.originalPrice = originalPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public ProductType getProductType(){
        return productType;
    }
}
